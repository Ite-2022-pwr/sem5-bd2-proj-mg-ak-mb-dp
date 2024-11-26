import Head from "next/head";
import {chakra} from "@chakra-ui/react";
import {AdminDashboard} from "@/components/AdminDashboard";
import {UsersList} from "@/components/UsersList";

export default function Home() {
    return (
        <>
            <Head>
                <title>Lista użytkowników</title>
                <meta name="description" content="Users list" />
                <meta name="viewport" content="width=device-width, initial-scale=1" />
                <link rel="icon" href="/favicon.ico" />
            </Head>
            <chakra.main>
                <UsersList />
            </chakra.main>
        </>
    )
}