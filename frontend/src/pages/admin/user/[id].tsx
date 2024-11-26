import Head from "next/head";
import {chakra} from "@chakra-ui/react";
import {UserPage} from "@/components/UserPage";

export default function User() {
    return (
        <>
            <Head>
                <title>Strona użytkownika</title>
                <meta name="description" content="User page" />
                <meta name="viewport" content="width=device-width, initial-scale=1" />
                <link rel="icon" href="/favicon.ico" />
            </Head>
            <chakra.main>
                <UserPage />
            </chakra.main>
        </>
    )
}