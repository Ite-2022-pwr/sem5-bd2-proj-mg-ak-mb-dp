import {useRouter} from "next/router";
import {useAuth} from "@/provider/AuthProvider";
import React, {useState} from "react";
import {CredentialsDto} from "@/model/CredentialsDto";
import {Flex, Input} from "@chakra-ui/react";
import {AuthService} from "@/service/AuthService";
import {isErrorDto} from "@/service/utils";
import system from "@/theme";

export const LoginPage = () => {
    const router = useRouter();
    const {setToken} = useAuth();
    const [formData, setFormData] = useState<CredentialsDto>({
        email: '',
        password: ''
    });
    const authService = new AuthService();

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const {name, value} = e.target;
        setFormData(prevData => ({...prevData, [name]: value}))
    }

    const handleSubmit = async (e: React.ChangeEvent<HTMLFormElement>) => {
        e.preventDefault();
        if(formData.password === '' || formData.email === '') {
            return;
        }
        const data = await authService.login(formData);
        if(isErrorDto(data)) {
            return;
        }
        setToken(data.token);
        await router.push('/');
    }

    return (
        <Flex
            width="100%"
            direction="column"
        >
            <form onSubmit={handleSubmit}>
                <Input
                    placeholder="Email address"
                    type={'text'}
                    value={formData.email}
                    name={'email'}
                    onChange={handleChange}
                />

                <Input
                    placeholder="Password"
                    type={'password'}
                    value={formData.password}
                    name={'password'}
                    onChange={handleChange}
                />

                <button
                    type="submit"
                >
                    Login
                </button>
            </form>
        </Flex>
    )
}