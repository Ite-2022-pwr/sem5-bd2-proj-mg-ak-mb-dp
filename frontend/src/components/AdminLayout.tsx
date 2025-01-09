import React, {ReactNode} from "react";
import {Box, HStack, VStack, Text, Flex, Button} from "@chakra-ui/react";
import {useRouter} from "next/router";

interface AdminLayoutProps {
    children: ReactNode;
}

interface NavbarItem {
    label: string;
    url: string;
}

export const AdminLayout:React.FC<AdminLayoutProps> = ({ children }) => {
    const router = useRouter();
    return (
        <HStack height="100%" width="100%" align="stretch" gap={50}>
            <VStack width={"25%"} paddingTop={15}>
                <Text textAlign={"center"} fontSize={30}>
                    Dziennik elektroniczny &#34;GEJzer&#34;
                </Text>
                <Flex width="100%" direction={"column"} padding={5} gap={10} >
                    {navbarItems.map((item) => (
                        <Button variant={"outline"} fontSize={20} key={item.label} onClick={() => router.push(item.url)}>
                            {item.label}
                        </Button>
                    ))}
                </Flex>
            </VStack>
            <Box overflowY="auto" width="75%">
                { children }
            </Box>
        </HStack>
    )
}



export const navbarItems: NavbarItem[] = [
    {
        label: 'Create Lesson',
        url: '/admin/lesson/create'
    },
    {
        label: 'Users',
        url: '/admin/users'
    },
    {
        label: 'Grades',
        url: '/admin/grades'
    }
]