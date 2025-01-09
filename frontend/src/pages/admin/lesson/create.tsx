import Head from "next/head";
import {chakra} from "@chakra-ui/react";
import {AdminDashboard} from "@/components/AdminDashboard";
import {UsersList} from "@/features/user/UsersList";
import {LessonPage} from "@/features";

export default function CreateLesson() {
    return (
        <>
            <Head>
                <title>Tworzenie lekcji</title>
                <meta name="description" content="Create lesson" />
                <meta name="viewport" content="width=device-width, initial-scale=1" />
                <link rel="icon" href="/favicon.ico" />
            </Head>
            <chakra.main>
                <LessonPage />
            </chakra.main>
        </>
    )
}