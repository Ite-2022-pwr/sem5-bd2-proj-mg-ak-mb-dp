import {AppProps} from "next/app";
import {ChakraProvider, Flex} from "@chakra-ui/react";
import system from "@/theme";
import { useState} from "react";
import {QueryClient, QueryClientProvider} from "@tanstack/react-query";
import {AuthProvider} from "@/provider/AuthProvider";
import {useRouter} from "next/router";
import {Header} from "@/components/Header";
import {AdminLayout} from "@/components/AdminLayout";

export default function App(appProps: AppProps) {
    const [queryClient] = useState(() => new QueryClient())
    return (
        <QueryClientProvider client={queryClient}>
            <AuthProvider>
                <ChakraProvider value={system}>
                    <Flex direction={"column"}>
                        <Header />
                        <ContentWrapper {...appProps} />
                    </Flex>
                </ChakraProvider>
            </AuthProvider>
        </QueryClientProvider>
    );
}

export const ContentWrapper = ({ Component, pageProps }: AppProps) => {
    const router = useRouter();
    const isAdminSubdirectory = router.pathname.startsWith('/admin');

    return isAdminSubdirectory ? (
        <AdminLayout>
            <Component {...pageProps} />
        </AdminLayout>
    ) : (
        <Component {...pageProps} />
    )
}