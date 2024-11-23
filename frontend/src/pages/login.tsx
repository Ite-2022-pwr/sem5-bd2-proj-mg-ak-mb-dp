import Head from "next/head";
import {chakra} from "@chakra-ui/react";
import {LoginPage} from "@/features";

export default function Login() {
    return (
        <>
            <Head>
                <title></title>
                <meta name="description" content="Strona główna" />
                <meta name="viewport" content="width=device-width, initial-scale=1" />
                <link rel="icon" href="/favicon.ico" />
            </Head>
            <chakra.main>
                <LoginPage />
            </chakra.main>
        </>
    );
}
