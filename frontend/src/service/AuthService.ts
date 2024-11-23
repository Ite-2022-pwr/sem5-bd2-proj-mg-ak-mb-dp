import {CredentialsDto} from "@/model/CredentialsDto";
import {JwtDto} from "@/model/JwtDto";
import {EntityServiceBase} from "@/service/EntityServiceBase";
import {ErrorDto} from "@/model/ErrorDto";

export class AuthService extends EntityServiceBase {

    constructor() {
        super('/auth');
    }

    public async login(dto: CredentialsDto): Promise<JwtDto | ErrorDto> {
        const response = await this.post<JwtDto, CredentialsDto>('/login', dto);
        return response;
    }
}