import {EntityServiceBase} from "@/service/EntityServiceBase";
import {UserDto} from "@/model/UserDto";

export class UserService extends EntityServiceBase {
    constructor() {
        super('/user');
    }

    public async getUsers() {
        return this.get<UserDto[]>('');
    }
}