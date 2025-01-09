import {createListCollection, Flex, Input} from "@chakra-ui/react";
import {useRouter} from "next/router";
import React, {useEffect, useMemo, useState} from "react";
import {LessonDto} from "@/model/LessonDto";
import {LessonService} from "@/service/LessonService";
import {isErrorDto} from "@/service/utils";
import {Field} from "@/components/ui/field";
import {SchoolClassDto} from "@/model/SchoolClassDto";
import {SchoolClassService} from "@/service/SchoolClassService";
import {SelectItem, SelectLabel, SelectRoot, SelectTrigger, SelectValueText} from "@/components/ui/select";
import {SelectContent} from "@ark-ui/react";

export const LessonPage = () => {
    const router = useRouter();

    const { id } = router.query;
    const [lesson, setLesson] = useState<LessonDto>(emptyLesson);
    const lessonId = typeof id === "string" ? id : "";

    const [schoolClasses, setSchoolClasses] = useState<SchoolClassDto[] | null>(null);

    useEffect(() => {
        if(schoolClasses === null) {
            const schoolClassesService = new SchoolClassService();
            const fetchSchoolClasses = async () => {
                const fetchSchoolClasses = await schoolClassesService.getSchoolClasses();
                if(!isErrorDto(fetchSchoolClasses)) {
                    setSchoolClasses(fetchSchoolClasses);
                }
            }
            fetchSchoolClasses();
        }

        if(lessonId) {
            const lessonService = new LessonService();
            const fetchLessonData = async () => {
                const fetchedLesson = await lessonService.getLesson(lessonId);
                if(!isErrorDto(fetchedLesson)) {
                    setLesson({
                        id: fetchedLesson.id || '',
                        topic: fetchedLesson.topic || '',
                        dateTimeStart: fetchedLesson.dateTimeStart || '',
                        dateTimeEnd: fetchedLesson.dateTimeEnd || '',
                    });
                }
            }
            fetchLessonData();
        }
    }, [router, lessonId]);

    const schoolClassesItems = useMemo(() => {
        return createListCollection<SchoolClassDto>({
            items: schoolClasses || [],
            itemToString: (item) => item.name,
            itemToValue: (item) => item.id
        });
    }, [schoolClasses])

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const { name, value } = e.target;
        setLesson(prevData => ({...prevData, [name]: value}))
    }

    const handleSubmit = (e: React.ChangeEvent<HTMLFormElement>) => {

    }

    return (
        <Flex marginTop={5} marginRight={5} direction={"column"}>
            <form onSubmit={handleSubmit}>
                <Field label={"Topic"} required>
                    <Input value={lesson.topic} name={"topic"} onChange={handleChange} placeholder={"Topic"} variant={"outline"}/>
                </Field>
                <Field label={"Start date time"} required>
                    <Input type={"datetime-local"} value={lesson.dateTimeStart} name={"dateTimeStart"} onChange={handleChange} placeholder={"Start time"} variant={"outline"}/>
                </Field>
                <Field label={"End date time"} required>
                    <Input type={"datetime-local"} value={lesson.dateTimeEnd} name={"dateTimeEnd"} onChange={handleChange} placeholder={"End time"} variant={"outline"}/>
                </Field>
                <SelectRoot collection={schoolClassesItems}>
                    <SelectLabel>Class</SelectLabel>
                    <SelectTrigger>
                        <SelectValueText placeholder={"Class"}/>
                    </SelectTrigger>
                    <SelectContent>
                        {schoolClassesItems.items.map((item) => (
                            <SelectItem item={item} key={item.id}>
                                {item.name}
                            </SelectItem>
                        ))}
                    </SelectContent>
                </SelectRoot>
            </form>
        </Flex>
    );
}

const emptyLesson: LessonDto = {
    id: '',
    topic: '',
    dateTimeStart: '',
    dateTimeEnd: '',
}