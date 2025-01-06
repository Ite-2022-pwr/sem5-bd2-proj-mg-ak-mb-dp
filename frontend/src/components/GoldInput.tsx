import React, {useState} from "react";
import {Box, Icon, IconButton, Input} from "@chakra-ui/react";
import {InputGroup} from "@/components/ui/input-group";
import {LuEye, LuEyeOff, LuLock, LuUser} from "react-icons/lu";

interface Props {
    inputType: string;
    value: any;
}

const focusStyle = {outline: "none", border: "none", boxShadow: "none"};

const GoldInput: React.FC<Props> = (props) => {
    const [passwordVisible, setPasswordVisible] = useState(false);
    return (
        <Box margin={3} borderColor={"#D9C466"} color={"#D9C466"} borderWidth={1} borderRadius={"lg"}>
            { props.inputType === "text" ? (
                <InputGroup flex={"1"} startElement={<LuUser style={{color: "#D9C466"}}/>}>
                    <Input
                        type={"text"}
                        value={props.value}
                        border={0}
                        _focus={focusStyle}
                        {...props}
                    />
                </InputGroup>
            ) : (props.inputType === "password") ? (
                <InputGroup
                    flex={"1"}
                    startElement={<LuLock style={{color: "#D9C466"}}/>}
                    endElement={ passwordVisible ? <LuEyeOff onClick={() => setPasswordVisible(prev => !prev)} style={{color: "#D9C466"}}/>
                        : <LuEye onClick={() => setPasswordVisible(prev => !prev)} style={{color: "#D9C466"}}/>}
                >
                    <Input
                        type={passwordVisible ? "text" : "password"}
                        value={props.value}
                        border={0}
                        _focus={focusStyle}
                        {...props}
                    />
                </InputGroup>
            ) : (
                <></>
            )}
        </Box>
    );
}

export default GoldInput;