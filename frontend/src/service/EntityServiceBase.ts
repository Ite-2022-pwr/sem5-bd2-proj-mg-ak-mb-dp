import apiAxiosClient from "@/config/axiosConfig";
import axios, {AxiosResponse} from "axios";
import {ErrorDto} from "@/model/ErrorDto";

export abstract class EntityServiceBase {
    protected controllerUrl: string;

    protected constructor(controllerUrl: string) {
        this.controllerUrl = process.env.NEXT_PUBLIC_BACKEND_URL + controllerUrl;
    }

    protected async get<T>(url: string): Promise<T | ErrorDto> {
        try {
            const response: AxiosResponse<T> = await apiAxiosClient.get(`${this.controllerUrl}${url}`);
            return response.data as T;
        } catch (error: unknown) {
            return this.parseError(error);
        }
    }

    protected async post<T, D>(url: string, data: D): Promise<T | ErrorDto> {
        try {
            const response: AxiosResponse<T> = await apiAxiosClient.post(`${this.controllerUrl}${url}`, data);
            return response.data as T;
        } catch (error: unknown) {
            return this.parseError(error);
        }
    }

    protected async put<T, D>(url: string, data: D): Promise<T | ErrorDto> {
        try {
            const response: AxiosResponse<T> = await apiAxiosClient.put(`${this.controllerUrl}${url}`, data);
            return response.data as T;
        } catch (error: unknown) {
            return this.parseError(error);
        }
    }

    private parseError = (error: unknown): ErrorDto => {
        let code = 'UNKNOWN';
        let message = 'An unexpected error occurred.';
        let accessRevoked = false;

        if(axios.isAxiosError(error)) {
            if(error.response) {
                const data = error.response.data;
                code = data.code || error.response.status.toString();
                message = data.message || `Error: ${error.response.status}`
                accessRevoked = data.accessRevoked || false;
            } else if (error.request) {
                code = "NO_RESPONSE";
                message = 'No response from the server. Please try again later.';
            } else {
                code = 'REQUEST_SETUP_ERROR';
                message = error.message;
            }
        } else {
            code = "REQUEST_SETUP_ERROR";
            message = error.message;
        }

        return { code, message, accessRevoked };
    }
}