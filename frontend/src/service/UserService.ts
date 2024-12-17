import {EntityServiceBase} from "@/service/EntityServiceBase";
import {UserDto} from "@/model/UserDto";
import {JwtDto} from "@/model/JwtDto";
import {ErrorDto} from "@/model/ErrorDto";

export class UserService extends EntityServiceBase {
    constructor() {
        super('/user');
    }

    public async getUsers() {
        return this.get<UserDto[]>('');
    }

    public async editUser(dto: UserDto, id: string) {
        return this.put<UserDto, UserDto>(`/${id}`, dto);
    }

    public async getUserById(id: string) {
        return this.get<UserDto>(`/${id}`);
    }

    public async authenticated(): Promise<UserDto | ErrorDto> {
        const response = await this.get<UserDto | ErrorDto>('/me');
        return response;
    }
}