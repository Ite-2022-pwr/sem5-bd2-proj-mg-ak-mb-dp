import {EntityServiceBase} from "@/service/EntityServiceBase";
import {SchoolClassDto} from "@/model/SchoolClassDto";

export class SchoolClassService extends EntityServiceBase {
    constructor() {
        super('/school-class');
    }

    public async getSchoolClasses() {
        return super.get<SchoolClassDto[]>('');
    }
}