import {Flex, Input} from "@chakra-ui/react"
import {useRouter} from "next/router";
import {UserDto} from "@/model/UserDto";
import React, {useEffect, useState} from "react";
import {Field} from "@/components/ui/field";
import {UserService} from "@/service/UserService";
import {isErrorDto} from "@/service/utils";
import {Button} from "@/components/ui/button";

export const UserPage = () => {
    const router = useRouter();
    const { id } = router.query;

    const [userData, setUserData] = useState<UserDto>(emptyUser);

    const userId = typeof id === "string" ? id : "";
    const userService = new UserService();

    useEffect(() => {
        if(userId) {
            const userService = new UserService();
            const fetchUserData = async () => {
                const fetchedUser = await userService.getUserById(userId);
                if(!isErrorDto(fetchedUser)) {
                    setUserData({
                        id: fetchedUser.id || '',
                        email: fetchedUser.email || '',
                        firstName: fetchedUser.firstName || '',
                        secondName: fetchedUser.secondName || '',
                    });
                }
            };

            fetchUserData();
        }
    }, [router, userId]);

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const { name, value } = e.target;
        setUserData(prevData => ({...prevData, [name]: value}));
    }

    const handleSubmit = async (e: React.ChangeEvent<HTMLFormElement>) => {
        e.preventDefault();
        const uData = await userService.editUser(userData, userId);
        if(!isErrorDto(uData)) {
            setUserData(uData);
        }
    }

    return (
        <Flex marginTop={5} marginRight={5} direction={"column"}>
            <form onSubmit={handleSubmit}>
                <Field label={"First name"} required>
                    <Input value={userData.firstName} name="firstName" onChange={handleChange} placeholder={"First Name"} variant={"outline"}/>
                </Field>
                <Field label={"Second name"} required>
                    <Input value={userData.secondName} name="secondName" onChange={handleChange} placeholder={"Last Name"} variant={"outline"}/>
                </Field>
                <Field label={"Email"} required>
                    <Input value={userData.email} name="email" onChange={handleChange} placeholder={"test@example.com"} variant={"outline"}/>
                </Field>
                <Button type={"submit"} variant={"outline"} marginTop={5}>
                    Zapisz
                </Button>
            </form>
        </Flex>
    );
}

const emptyUser: UserDto = {
    id: '',
    email: '',
    firstName: '',
    secondName: '',
}