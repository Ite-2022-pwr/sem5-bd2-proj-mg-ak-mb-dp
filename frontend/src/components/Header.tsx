import {Box, Button, Center, Flex, Text} from "@chakra-ui/react";
import {useAuth} from "@/service/provider/AuthProvider";
import {useEffect, useState} from "react";
import {UserService} from "@/service/UserService";
import {UserDto} from "@/model/UserDto";
import {isErrorDto} from "@/service/utils";
import {useRouter} from "next/router";
export const Header = () => {

    const { token } = useAuth(false);
    const router = useRouter();
    const [authenticatedUser, setAuthenticatedUser] = useState<UserDto | null>(null);

    useEffect(() => {
        if(token) {
            const userService = new UserService();
            const fetchAuthenticatedUser = async () => {
                const fetchedUser = await userService.authenticated();
                if(!isErrorDto(fetchedUser)) {
                    setAuthenticatedUser(fetchedUser);
                }
            }

            fetchAuthenticatedUser();
        }
    }, [router, token]);

    return (
        <Box
            width="100%"
            backgroundColor="#1f5bab"
            position={"relative"}
            padding={5}
        >
            {authenticatedUser !== null ? (
                <Flex justify={"flex-end"}>
                    <Button padding={1} marginRight={5} textSize={5} onClick={() => router.push('/admin')}>
                        Panel administratora
                    </Button>
                    <Center>
                        <Text fontWeight={"bold"} fontSize={15}>
                            {authenticatedUser.firstName} {authenticatedUser.secondName}
                        </Text>
                    </Center>
                </Flex>
            ) : (
                <Flex justify={"flex-end"}>
                    <Button paddingY={0} onClick={() => router.push('/login')}>
                        Zaloguj się
                    </Button>
                </Flex>
            )}
        </Box>
    )
}