import Head from "next/head";
import {chakra} from "@chakra-ui/react";
import {AdminDashboard} from "@/components/AdminDashboard";

export default function Home() {
    return (
        <>
            <Head>
                <title>Dashboard admina</title>
                <meta name="description" content="Admin dashboard" />
                <meta name="viewport" content="width=device-width, initial-scale=1" />
                <link rel="icon" href="/favicon.ico" />
            </Head>
            <chakra.main>
                <AdminDashboard />
            </chakra.main>
        </>
    )
}