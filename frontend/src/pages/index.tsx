import Head from "next/head";
import {chakra} from "@chakra-ui/react"
export default function Home() {
    return (
        <>
            <Head>
                <title></title>
                <meta name="description" content="Strona główna" />
                <meta name="viewport" content="width=device-width, initial-scale=1" />
                <link rel="icon" href="/favicon.ico" />
            </Head>
            <chakra.main>
            </chakra.main>
        </>
    )
}