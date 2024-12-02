import random
import uuid
from faker import Faker
from datetime import datetime, timedelta

fake = Faker()

# Funkcja generująca losowe daty w podanym zakresie
def random_date(start_date, end_date):
    delta = end_date - start_date
    random_days = random.randint(0, delta.days)
    return (start_date + timedelta(days=random_days)).strftime('%Y-%m-%d %H:%M:%S')

# Funkcja generująca wiersze INSERT w paczkach z komentarzem
def generate_bulk_inserts(file_name, table_name, column_names, rows_count, row_generator):
    batch_size = 1000  # Liczba wierszy w jednej paczce
    with open(file_name, "a", encoding="utf-8") as file:
        file.write(f"\n-- Wstawianie danych do tabeli {table_name}\n")
        for i in range(0, rows_count, batch_size):
            values = []
            for _ in range(min(batch_size, rows_count - i)):
                values.append(row_generator())
            file.write(
                f"INSERT INTO {table_name} ({', '.join(column_names)}) VALUES\n" +
                ",\n".join(values) +
                ";\n"
            )
    print(f"Wygenerowano dane dla tabeli {table_name} do pliku {file_name}!")

# Generowanie losowych danych dla każdej tabeli
post_codes_ids = []
address_ids = []
users_ids = []
students_ids = []
parents_ids = []
teachers_ids = []
class_ids = []
school_subject_ids = []
lesson_ids = []
phone_number_ids = []

# PostCodes
def generate_post_code_row():
    post_code_id = str(uuid.uuid4())
    post_codes_ids.append(post_code_id)
    return f"('{post_code_id}', '{fake.postcode()}', '{fake.state()}')"

# Addresses
def generate_address_row():
    address_id = str(uuid.uuid4())
    address_ids.append(address_id)
    return f"('{address_id}', '{random.choice(post_codes_ids)}', '{fake.street_name()[:45]}', '{fake.building_number()}', '{random.randint(1, 100)}')"

# Users
def generate_user_row():
    user_id = str(uuid.uuid4())
    users_ids.append(user_id)
    role = random.choice(["teacher", "parent", "student"])
    return f"('{user_id}', '{str(uuid.uuid4())[:45]}', '{fake.password()}', '{str(uuid.uuid4())[:45]}', '{fake.first_name()}', '{fake.first_name() if random.random() > 0.5 else ''}', '{fake.last_name()}', '{random.choice(address_ids)}', '911')"

# Students
def generate_student_row():
    student_id = str(uuid.uuid4())
    students_ids.append(student_id)
    return f"('{student_id}', '{random.choice(users_ids)}', '{random.choice(class_ids)}', '{fake.date_of_birth(minimum_age=10, maximum_age=18)}', '{random.randint(10, 18)}', '{random.choice(['Male', 'Female', 'Other'])}')"

# Parents
def generate_parent_row():
    parent_id = str(uuid.uuid4())
    parents_ids.append(parent_id)
    return f"('{parent_id}', '{random.choice(users_ids)}', '{random.choice(['Father', 'Mother', 'LegalGuardian', 'Parent'])}', 'description', '{random.choice(phone_number_ids)}')"

# Teachers
def generate_teacher_row():
    teacher_id = str(uuid.uuid4())
    teachers_ids.append(teacher_id)
    return f"('{teacher_id}', '{random.choice(users_ids)}', '{random_date(datetime(2020, 1, 1), datetime(2023, 12, 31))}', '{random.choice([0, 1])}')"

# Classes
def generate_class_row():
    class_id = str(uuid.uuid4())
    class_ids.append(class_id)
    return f"('{class_id}', '{random.choice(['1a', '1b', '2a', '2b', '3b', '3a'])}', '{random.randint(1, 4)}', '{random_date(datetime(2020, 1, 1), datetime(2023, 12, 31))}')"

# SchoolSubjects
def generate_school_subject_row():
    subject_id = str(uuid.uuid4())
    school_subject_ids.append(subject_id)
    return f"('{subject_id}', '{fake.word()}', '{random_date(datetime(2020, 1, 1), datetime(2023, 12, 31))}', '{fake.url()[:45]}')"

# Lessons
def generate_lesson_row():
    lesson_id = str(uuid.uuid4())
    lesson_ids.append(lesson_id)
    return f"('{lesson_id}', '{random.choice(school_subject_ids)}', '{random.choice(teachers_ids)}', '{random.choice(class_ids)}', '{fake.word()}', '{random_date(datetime(2020, 1, 1), datetime(2023, 12, 31))}', '{random_date(datetime(2020, 1, 1), datetime(2023, 12, 31))}')"

# Grades
def generate_grade_row():
    return f"('{uuid.uuid4()}', '{random.choice(students_ids)}', '{random.choice(teachers_ids)}', {random.randint(1, 6)}, '{fake.sentence(nb_words=6)[:45]}', '{random_date(datetime(2020, 1, 1), datetime(2023, 12, 31))}', {random.randint(1, 10)}, '{random.choice(school_subject_ids)}')"

# Presences
def generate_presence_row():
    return f"('{uuid.uuid4()}', '{random.choice(lesson_ids)}', '{random.choice(students_ids)}', '{random.choice(['Present', 'UnexcusedAbsent', 'ExcusedAbsent'])}', '{random_date(datetime(2020, 1, 1), datetime(2023, 12, 31))}', '{random_date(datetime(2020, 1, 1), datetime(2023, 12, 31))}')"

# Phone numbers
def generate_phone_number_row():
    phone_number_id = str(uuid.uuid4())
    phone_number_ids.append(phone_number_id)
    return f"('{phone_number_id}', '911')"

# Generowanie zapytań
output_file = "full_database_data.sql"

# Wyczyść plik wyjściowy
open(output_file, "w").close()

# Kolejność generowania
generate_bulk_inserts(output_file, "post_codes", ["id", "post_code", "region_name"], 50, generate_post_code_row)
generate_bulk_inserts(output_file, "phone_numbers", ["id", "phone_number"], 1000, generate_phone_number_row)
generate_bulk_inserts(output_file, "addresses", ["id", "id_post_code", "street", "building_number", "apartment_number"], 200, generate_address_row)
generate_bulk_inserts(output_file, "users", ["id", "user_login", "password_hash", "email", "first_name", "second_name", "surname", "id_address", "phone_number"], 20000, generate_user_row)
generate_bulk_inserts(output_file, "classes", ["id", "class_name", "year_of_study", "year_started"], 20, generate_class_row)
generate_bulk_inserts(output_file, "school_subjects", ["id", "subject_name", "school_year", "link_to_subject_program"], 10, generate_school_subject_row)
generate_bulk_inserts(output_file, "teachers", ["id", "id_user", "lastcocrdate", "one_leave"], 20, generate_teacher_row)
generate_bulk_inserts(output_file, "students", ["id", "id_user", "id_class", "date_of_birth", "age", "gender"], 100, generate_student_row)
generate_bulk_inserts(output_file, "parents", ["id", "id_user", "parent_role", "description", "id_phone_number"], 50, generate_parent_row)
generate_bulk_inserts(output_file, "lessons", ["id", "id_school_subject", "id_teacher", "id_class", "topic", "date_time_start", "date_time_end"], 1000, generate_lesson_row)
generate_bulk_inserts(output_file, "grades", ["id", "id_student", "id_teacher", "number_grade", "grade_description", "date_created", "weight", "id_subject"], 30000, generate_grade_row)
generate_bulk_inserts(output_file, "presences", ["id", "id_lesson", "id_student", "presence_type", "created", "modified"], 100000, generate_presence_row)

print(f"Wszystkie dane zostały wygenerowane do pliku {output_file}!")
