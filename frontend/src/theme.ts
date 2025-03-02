import {createSystem, defaultConfig, defaultSystem, defineConfig} from "@chakra-ui/react";

const config = defineConfig({
    theme: {
        tokens: {
            colors: {},
        },
    },
});

const system = createSystem(defaultConfig, config);

export default system;