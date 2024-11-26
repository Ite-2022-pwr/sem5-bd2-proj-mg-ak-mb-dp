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
        <HStack height="100%" width="100%" spacing={0} align="stretch" gap={50}>
            <VStack width={"25%"}>
                <Text textAlign={"center"} fontSize={30}>
                    Dziennik elektroniczny &#34;GEJzer&#34;
                </Text>
                <Flex width="100%" direction={"column"} padding={20} gap={20} >
                    {navbarItems.map((item) => (
                        <Button fontSize={20} key={item.label} onClick={() => router.push(item.url)}>
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
        label: 'Dashboard',
        url: '/admin/dashboard'
    },
    {
        label: 'Users',
        url: '/admin/users'
    },
    {
        label: 'Profile',
        url: ''
    },
    {
        label: 'Settings',
        url: ''
    }
]