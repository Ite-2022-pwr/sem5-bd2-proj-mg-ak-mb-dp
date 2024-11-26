import {
    Flex,
    Heading, IconButton,
    Table
} from "@chakra-ui/react";
import {UserDto} from "@/model/UserDto";
import {FaRegEdit} from "react-icons/fa";
import {useRouter} from "next/router";
import {useEffect, useState} from "react";
import {UserService} from "@/service/UserService";
import {isErrorDto} from "@/service/utils";

export const UsersList = () => {

    const router = useRouter();

    const [users, setUsers] = useState<UserDto[]>([]);


    useEffect(() => {
        const userService = new UserService();
        const fetchUserData = async () => {
            const fetchedUsers = await userService.getUsers();
            if(!isErrorDto(fetchedUsers)) {
                console.log(fetchedUsers);
                setUsers(fetchedUsers);
            }
        };

        fetchUserData();
    }, [router]);

    const userEditClick = async (userId: string) => {
        await router.push(`/admin/user/${userId}`);
    }

    return (
        <Flex direction={"column"}>
            <Heading>Users</Heading>
            <Table.Root variant={"outline"} striped>
                <Table.Header>
                    <Table.Row>
                        <Table.ColumnHeader>First name</Table.ColumnHeader>
                        <Table.ColumnHeader>Second name</Table.ColumnHeader>
                        <Table.ColumnHeader>Email</Table.ColumnHeader>
                        <Table.ColumnHeader>Action</Table.ColumnHeader>
                    </Table.Row>
                </Table.Header>
                <Table.Body>
                    {users.map((user) => (
                        <Table.Row key={user.email}>
                            <Table.Cell>{user.firstName}</Table.Cell>
                            <Table.Cell>{user.secondName}</Table.Cell>
                            <Table.Cell>{user.email}</Table.Cell>
                            <Table.Cell>
                                <IconButton arial-label="Edit user" onClick={() => userEditClick(user.id)}>
                                    <FaRegEdit />
                                </IconButton>
                            </Table.Cell>
                        </Table.Row>
                    ))}
                </Table.Body>
            </Table.Root>
        </Flex>
    )
}