import {ErrorDto} from "@/model/ErrorDto";

export function isErrorDto(response: any): response is ErrorDto {
    return response && typeof response.code === 'string';
}