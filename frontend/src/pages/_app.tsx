import {AppProps} from "next/app";
import {ChakraProvider} from "@chakra-ui/react";
import system from "@/theme";
import {useState} from "react";
import {QueryClient, QueryClientProvider} from "@tanstack/react-query";
import {AuthProvider} from "@/provider/AuthProvider";

export default function App({ Component, pageProps }: AppProps) {
    const [queryClient] = useState(() => new QueryClient())
    return (
        <QueryClientProvider client={queryClient}>
            <AuthProvider>
                <ChakraProvider value={system}>
                    <Component {...pageProps} />
                </ChakraProvider>
            </AuthProvider>
        </QueryClientProvider>
    );
}