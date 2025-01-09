import React, {createContext, ReactNode, useContext, useEffect, useMemo, useState} from "react";
import apiAxiosClient from "@/config/axiosConfig";
import {useRouter} from "next/router";

interface AuthContextType {
    token: string | null;
    setToken: (token: string | null) => void;
}

const AuthContext = createContext<AuthContextType | undefined>(undefined);

interface AuthProviderProps {
    children: ReactNode;
}

export const AuthProvider: React.FC<AuthProviderProps> = ({ children }) => {
    const [token, setToken_] = useState<string | null>(
        typeof window !== 'undefined' ? localStorage.getItem('token') : null
    );

    const setToken = (newToken: string | null) => {
        setToken_(newToken);
    };

    useEffect(() => {
        if(token) {
            apiAxiosClient.defaults.headers.common["Authorization"] = "Bearer " + token;
            localStorage.setItem('token', token);
        } else {
            delete apiAxiosClient.defaults.headers.common["Authorization"];
            localStorage.removeItem('token');
        }
    }, [token]);

    const contextValue = useMemo(() => ({
        token, setToken
    }), [token]);

    return (
        <AuthContext.Provider value={contextValue}>
            { children }
        </AuthContext.Provider>
    )
}

export const useAuth = (redirectOnMissing: boolean = false) => {
    const context = useContext(AuthContext);
    const router = useRouter();
    if(!context) {
        throw new Error('useAuth must used within AuthProvider');
    }
    const { token } = context;
    useEffect(() => {
        if(redirectOnMissing && !token) {
            router.push('/login')
        }
    }, [token, redirectOnMissing, router]);

    return context;
}