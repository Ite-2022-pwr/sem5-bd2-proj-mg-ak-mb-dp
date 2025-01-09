import {EntityServiceBase} from "@/service/EntityServiceBase";
import {LessonDto} from "@/model/LessonDto";

export class LessonService extends EntityServiceBase {

    constructor() {
        super('/lesson');
    }

    public async getLessons() {
        return await super.get<LessonDto[]>('/');
    }

    public async getLesson(id: string) {
        return await super.get<LessonDto>(`/${id}`);
    }
}