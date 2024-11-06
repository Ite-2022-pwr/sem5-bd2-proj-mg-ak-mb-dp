# Projekt i Struktura Bazy Danych `school_normalized`

## 1. **Projekt i Struktura Bazy Danych**

### **a. Tabele i Ich Przeznaczenie**

#### **1. Users (Użytkownicy)**
- **Przeznaczenie:** Przechowuje informacje o wszystkich użytkownikach systemu, takich jak uczniowie, rodzice, nauczyciele, dyrektorzy, administratorzy danych i techniczni.
- **Kluczowe Atrybuty:**
  - `IdUser` (PK): Unikalny identyfikator użytkownika.
  - `Login`: Nazwa użytkownika do logowania.
  - `HashedPassword`: Hasło użytkownika w postaci zaszyfrowanej.
  - `Email`: Adres e-mail użytkownika (opcjonalny).
  - `Role`: Rola użytkownika (ENUM('student','parent','teacher','headmaster','admin') domyślnie 'student').
  - `FirstName`, `SecondName`, `Surname`: Imię, drugie imię i nazwisko użytkownika.
  - `IdAddress` (FK): Odniesienie do adresu w tabeli `Adresses`.
  

#### **2. PostCodes (Kody Pocztowe)**
- **Przeznaczenie:** Zawiera kody pocztowe wraz z nazwami regionów, takich jak miasta, przedmieścia czy wsie.
- **Kluczowe Atrybuty:**
  - `IdPostCode` (PK): Unikalny identyfikator kodu pocztowego.
  - `PostCode` : Kod pocztowy.
  - `RegionName`: Nazwa regionu związana z kodem pocztowym.

#### **3. Adresses (Adresy)**
- **Przeznaczenie:** Przechowuje szczegółowe informacje adresowe użytkowników.
- **Kluczowe Atrybuty:**
  - `IdAddress` (PK): Unikalny identyfikator adresu.
  - `IdPostCode` (FK): Odniesienie do kodu pocztowego w tabeli `PostCodes`.
  - `Street` (opcjonalne): Ulica.
  - `BuildingNumber`: Numer budynku.
  - `AdditionalBuildingIdentifier` (opcjonalny): Dodatkowy identyfikator budynku (np. litera w numerze budynku).
  - `AppartmentNumber` (opcjonalny): Numer mieszkania.

#### **4. Classes (Klasy)**
- **Przeznaczenie:** Przechowuje informacje o klasach szkolnych.
- **Kluczowe Atrybuty:**
  - `IdClass` (PK): Unikalny identyfikator klasy.
  - `YearOfStudy`: Rok nauki.
  - `YearStarted`: Rok rozpoczęcia nauki w klasie.

#### **5. Students (Uczniowie)**
- **Przeznaczenie:** Specjalizacja tabeli `Users` dla uczniów, zawierająca dodatkowe informacje.
- **Kluczowe Atrybuty:**
  - `IdStudent` (PK): Unikalny identyfikator ucznia.
  - `IdUser` (FK): Odniesienie do użytkownika w tabeli `Users`.
  - `IdClass` (FK): Odniesienie do klasy w tabeli `Classes`.
  - `DateOfBirth`: Data urodzenia ucznia.
  - `Age`: Wiek ucznia.
  - `Gender`: Płeć ucznia (`ENUM('male', 'female', 'other')`).

#### **6. Teachers (Nauczyciele)**
- **Przeznaczenie:** Specjalizacja tabeli `Users` dla nauczycieli, zawierająca dodatkowe informacje.
- **Kluczowe Atrybuty:**
  - `IdTeacher` (PK): Unikalny identyfikator nauczyciela.
  - `IdUser` (FK): Odniesienie do użytkownika w tabeli `Users`.
  - `LastCOCRDate`: Data ostatniego zaświadczenia o niekaralności.
  - `OnLeave`: Flaga wskazująca, czy nauczyciel jest na urlopie.

#### **7. SchoolSubjects (Przedmioty Szkolne)**
- **Przeznaczenie:** Przechowuje informacje o przedmiotach nauczanych w szkole.
- **Kluczowe Atrybuty:**
  - `IdSchoolSubject` (PK): Unikalny identyfikator przedmiotu.
  - `Name`: Nazwa przedmiotu.
  - `SchoolYear`: Rok szkolny, w którym przedmiot jest nauczany.
  - `LinkToSubjectProgram` (opcjonalny): Link do programu przedmiotu.

#### **8. Lessons (Lekcje)**
- **Przeznaczenie:** Przechowuje informacje o lekcjach.
- **Kluczowe Atrybuty:**
  - `IdLesson` (PK): Unikalny identyfikator lekcji.
  - `IdSchoolSubject` (FK): Odniesienie do przedmiotu w tabeli `SchoolSubjects`.
  - `IdTeacher` (FK): Odniesienie do nauczyciela w tabeli `Teachers`.
  - `IdClass` (FK): Odniesienie do klasy w tabeli `Classes`.
  - `Topic` (opcjonalny): Temat lekcji.
  - `Date`: Data i godzina lekcji.

#### **9. TeachersTeachingSubjects (Nauczyciele Nauczający Przedmioty)**
- **Przeznaczenie:** Łączy nauczycieli z przedmiotami, które nauczają.
- **Kluczowe Atrybuty:**
  - `IdTeacher` (FK): Odniesienie do nauczyciela w tabeli `Teachers`.
  - `IdSchoolSubject` (FK): Odniesienie do przedmiotu w tabeli `SchoolSubjects`.
- **Klucz Główny:** `IdTeacher`, `IdSchoolSubject`

#### **10. Grades (Oceny)**
- **Przeznaczenie:** Przechowuje oceny uczniów.
- **Kluczowe Atrybuty:**
  - `IdGrade` (PK): Unikalny identyfikator oceny.
  - `IdStudent` (FK): Odniesienie do ucznia w tabeli `Students`.
  - `IdTeacher` (FK): Odniesienie do nauczyciela w tabeli `Teachers`.
  - `IdSubject` (FK): Odniesienie do przedmiotu w tabeli `SchoolSubjects`.
  - `NumberGrade`: Numer oceny (domyślnie 1).
  - `Description`: Opis oceny.
  - `Date`: Data wystawienia oceny.
  - `Weight`: Waga oceny (np. 2 dla oceny z testu, 1 dla oceny z pracy klasowej).

#### **11. Parents (Rodzice)**
- **Przeznaczenie:** Specjalizacja tabeli `Users` dla rodziców.
- **Kluczowe Atrybuty:**
  - `IdParent` (PK): Unikalny identyfikator rodzica.
  - `IdUser` (FK): Odniesienie do użytkownika w tabeli `Users`.
  - `Role`: Rola rodzica (`ENUM('father', 'mother', 'parent', 'legal_guardian')`).

#### **12. ParentsStudentPairs (Powiązania Rodziców ze Studentami)**
- **Przeznaczenie:** Łączy rodziców ze studentami, umożliwiając przypisanie wielu rodziców do jednego ucznia i odwrotnie.
- **Kluczowe Atrybuty:**
  - `IdStudent` (FK): Odniesienie do ucznia w tabeli `Students`.
  - `IdParent` (FK): Odniesienie do rodzica w tabeli `Parents`.

#### **13. Messages (Wiadomości)**
- **Przeznaczenie:** Przechowuje wiadomości wysyłane między użytkownikami.
- **Kluczowe Atrybuty:**
  - `IdMessage` (PK): Unikalny identyfikator wiadomości.
  - `IdUserSender` (FK): Odniesienie do użytkownika wysyłającego wiadomość.
  - `Content`: Treść wiadomości.
  - `DateSent`: Data wysłania wiadomości.

#### **14. MessageUserReceiverPairs (Powiązania Wiadomości z Odbiorcami)**
- **Przeznaczenie:** Łączy wiadomości z ich odbiorcami.
- **Kluczowe Atrybuty:**
  - `IdMessage` (FK): Odniesienie do wiadomości w tabeli `Messages`.
  - `IdUserReceiver` (FK): Odniesienie do odbiorcy w tabeli `Users`.

#### **15. Presences (Frekwencja)**
- **Przeznaczenie:** Przechowuje informacje o obecności uczniów na lekcjach.
- **Kluczowe Atrybuty:**
  - `IdPresence` (PK): Unikalny identyfikator frekwencji.
  - `IdLesson` (FK): Odniesienie do lekcji w tabeli `Lessons`.
  - `IdStudent` (FK): Odniesienie do ucznia w tabeli `Students`.
  - `Type`: Typ obecności (`ENUM('present', 'excused_absence', 'unexcused_absence')`).

#### **16. PhoneNumbers (Numery Telefonów)**
- **Przeznaczenie:** Przechowuje numery telefonów użytkowników.
- **Kluczowe Atrybuty:**
  - `IdPhoneNumber` (PK): Unikalny identyfikator numeru telefonu.
  - `PhoneNumber`: Numer telefonu.

#### **17. PhoneNumbersParentsMatch (Powiązania Numerów Telefonów z Rodzicami)**
- **Przeznaczenie:** Łączy numery telefonów z rodzicami, umożliwiając dodanie opisu do każdego połączenia.
- **Kluczowe Atrybuty:**
  - `IdPhoneNumber` (FK): Odniesienie do numeru telefonu w tabeli `PhoneNumbers`.
  - `IdParent` (FK): Odniesienie do rodzica w tabeli `Parents`.
  - `Description`: Opis powiązania (np. "telefon domowy", "telefon komórkowy").

### **b. Relacje Między Tabelami**

#### **1. Relacje Jeden-do-Wielu (1:N)**
- **Users → Adresses:**
  - Jeden adres (`Adresses`) może być przypisany do wielu użytkowników (`Users`).
  - **Przykład:** Adres `IdAddress = 1` może być przypisany do użytkowników `IdUser = 1, 2, 3`.
  
- **Classes → Students:**
  - Jedna klasa (`Classes`) może mieć wielu uczniów (`Students`).
  - **Przykład:** Klasa `IdClass = 1` może mieć uczniów `IdStudent = 1, 2, 3`.

- **SchoolSubjects → Lessons:**
  - Jeden przedmiot (`SchoolSubjects`) może mieć wiele lekcji (`Lessons`).
  - **Przykład:** Przedmiot `IdSchoolSubject = 1` może mieć lekcje `IdLesson = 1, 2, 3`.

- **Teachers → Lessons:**
  - Jeden nauczyciel (`Teachers`) może prowadzić wiele lekcji (`Lessons`).
  - **Przykład:** Nauczyciel `IdTeacher = 1` może prowadzić lekcje `IdLesson = 1, 2`.

#### **2. Relacje Wielu-do-Wielu (M:N)**
- **TeachersTeachingSubjects (Nauczyciele Nauczający Przedmioty):**
  - Jeden nauczyciel może uczyć wielu przedmiotów, a jeden przedmiot może być nauczany przez wielu nauczycieli.
  - **Przykład:** Nauczyciel `IdTeacher = 1` może uczyć przedmiotów `IdSchoolSubject = 1, 2`, a przedmiot `IdSchoolSubject = 1` może być nauczany przez nauczycieli `IdTeacher = 1, 2`.
  
- **ParentsStudentPairs (Rodzice → Uczniowie):**
  - Jeden rodzic może mieć wielu uczniów, a jeden uczeń może mieć wielu rodziców.
  - **Przykład:** Rodzic `IdParent = 1` może mieć uczniów `IdStudent = 1, 2`, a uczeń `IdStudent = 1` może mieć rodziców `IdParent = 1, 2`.

#### **3. Relacja Jeden-do-Zerowego lub Wielu (1:0..N)**
- **Presences → Lessons:**
  - Lekcja (`Lessons`) może mieć wiele wpisów obecności (`Presences`), ale na początku roku szkolnego mogą nie istnieć żadne wpisy.
  - **Przykład:** Lekcja `IdLesson = 1` może mieć obecności `IdPresence = 1, 2, 3`, ale lekcja `IdLesson = 2` może nie mieć żadnych wpisów obecności.
- **Grades → Students:**
  - Uczeń (`Students`) może mieć wiele ocen (`Grades`), ale na początku roku szkolnego może nie mieć żadnych ocen.
  - **Przykład:** Uczeń `IdStudent = 1` może mieć oceny `IdGrade = 1, 2, 3`, ale uczeń `IdStudent = 2` może nie mieć żadnych ocen.

### **c. Klucze Obce i Spójność Danych**

#### **1. Przykład Kluczy Obcych Zapewniających Spójność**
- **Tabela `Students`:**
  - `IdUser` jest kluczem obcym odnoszącym się do `Users(IdUser)`.
  - `IdClass` jest kluczem obcym odnoszącym się do `Classes(IdClass)`.
  - **Jak to działa:** Zapewnia, że każdy uczeń jest powiązany z istniejącym użytkownikiem i klasą. Nie można dodać ucznia bez istniejącego użytkownika lub klasy, co zapobiega niespójnym danym.

- **Tabela `Presences`:**
  - `IdLesson` jest kluczem obcym odnoszącym się do `Lessons(IdLesson)`.
  - `IdStudent` jest kluczem obcym odnoszącym się do `Students(IdStudent)`.
  - **Jak to działa:** Zapewnia, że każda frekwencja odnosi się do istniejącej lekcji i istniejącego ucznia. Nie można dodać wpisu frekwencji dla nieistniejącej lekcji lub ucznia.

- **Tabela `Grades`:**
  - `IdSubject` jest kluczem obcym odnoszącym się do `SchoolSubjects(IdSchoolSubject)`.
  - `IdStudent` jest kluczem obcym odnoszącym się do `Students(IdStudent)`.
  - `IdTeacher` jest kluczem obcym odnoszącym się do `Teachers(IdTeacher)`.
  - **Jak to działa:** Każda ocena musi być przypisana do istniejącego przedmiotu, ucznia i nauczyciela. Nie można wprowadzić oceny dla przedmiotu, ucznia lub nauczyciela, który nie istnieje w odpowiednich tabelach.

### Widoki w Bazie Danych `school_normalized`

#### `StudentGradesView` – Widok Ocen Ucznia

Pozwala uczniowi zobaczyć swoje oceny z informacjami o przedmiocie, nauczycielu i wadze.

**Definicja widoku:**

```sql
CREATE VIEW StudentGradesView AS
SELECT
    g.IdGrade,
    g.IdStudent,
    ss.Name AS SubjectName,
    g.NumberGrade,
    g.Weight,
    g.Description,
    g.Date,
    CONCAT(tu.FirstName, ' ', tu.Surname) AS TeacherName
FROM
    Grades g
    INNER JOIN Students s ON g.IdStudent = s.IdStudent
    INNER JOIN Teachers t ON g.IdTeacher = t.IdTeacher
    INNER JOIN Users tu ON t.IdUser = tu.IdUser
    INNER JOIN SchoolSubjects ss ON g.IdSubject = ss.IdSchoolSubject;
```

**Użycie:**

Uczeń wyświetla swoje oceny:

```sql
SELECT *
FROM StudentGradesView
WHERE IdStudent = [TwojeIdStudenta];
```

---

#### `UserMessagesView` – Widok Wiadomości Użytkownika

Pozwala użytkownikowi odczytać swoje wiadomości wraz z informacjami o nadawcy.

**Definicja widoku:**

```sql
CREATE VIEW UserMessagesView AS
SELECT
    m.IdMessage,
    murp.IdUserReceiver,
    m.Content,
    m.DateSent,
    CONCAT(su.FirstName, ' ', su.Surname) AS SenderName
FROM
    Messages m
    INNER JOIN MessageUserReceiverPairs murp ON m.IdMessage = murp.IdMessage
    INNER JOIN Users su ON m.IdUserSender = su.IdUser;
```

**Użycie:**

Użytkownik wyświetla swoje wiadomości:

```sql
SELECT *
FROM UserMessagesView
WHERE IdUserReceiver = [TwojeIdUser];
```

---

#### `ChildPresencesView` – Widok Obecności Dziecka

Pozwala rodzicowi zobaczyć obecności swojego dziecka na lekcjach.

**Definicja widoku:**

```sql
CREATE VIEW ChildPresencesView AS
SELECT
    p.IdPresence,
    p.IdStudent,
    p.Type,
    l.DateTimeStart,
    l.Topic,
    ss.Name AS SubjectName,
    CONCAT(su.FirstName, ' ', su.Surname) AS StudentName
FROM
    Presences p
    INNER JOIN Lessons l ON p.IdLesson = l.IdLesson
    INNER JOIN SchoolSubjects ss ON l.IdSchoolSubject = ss.IdSchoolSubject
    INNER JOIN Students s ON p.IdStudent = s.IdStudent
    INNER JOIN Users su ON s.IdUser = su.IdUser
    INNER JOIN ParentsStudentPairs psp ON s.IdStudent = psp.IdStudent
WHERE
    psp.IdParent = [TwojeIdParent];
```

**Użycie:**

Rodzic wyświetla obecności dziecka:

```sql
SELECT *
FROM ChildPresencesView;
```

## 2. **Mechanizmy Zapewniające Poprawność Przechowywanych Informacji**

### **a. Normalizacja Bazy Danych**

Normalizacja to proces organizowania danych w bazie danych, aby zmniejszyć redundancję i zapewnić spójność. Baza `school_normalized` została zaprojektowana zgodnie z trzema pierwszymi formami normalnymi (1NF, 2NF, 3NF).

#### **Pierwsza Postać Normalna (1NF)**
- **Definicja:** Wszystkie tabele mają klucz główny, a wszystkie atrybuty zawierają tylko jedną wartość (wartości atomowe).
- **Przykład:**
  - **Tabela `Users`:**
    - Każdy rekord ma unikalny `IdUser`.
    - Atrybuty takie jak `FirstName` czy `Surname` zawierają tylko jedną wartość dla każdego rekordu, np. `FirstName = "Jan"`, `Surname = "Kowalski"`.

#### **Druga Postać Normalna (2NF)**
- **Definicja:** Baza jest w 2NF, jeśli jest w 1NF i wszystkie atrybuty niekluczowe są w pełni zależne od klucza głównego.
- **Przykład:**
  - **Tabela `Grades`:**
    - Klucz główny to `IdGrade`.
    - Atrybuty takie jak `NumberGrade`, `Description`, `Date` są w pełni zależne od `IdGrade`.
    - Nie ma częściowych zależności, ponieważ `IdGrade` jest pojedynczym atrybutem.

#### **Trzecia Postać Normalna (3NF)**
- **Definicja:** Baza jest w 3NF, jeśli jest w 2NF i nie ma zależności przechodnich między atrybutami.
- **Przykład:**
  - **Tabela `Users`:**
    - Atrybuty `FirstName`, `SecondName`, `Surname` są zależne tylko od `IdUser`.

### **b. Klucze Główne i Unikalne Ograniczenia**

#### **Klucze Główne (`PRIMARY KEY`)**

- **Definicja:** Unikalny identyfikator każdego rekordu w tabeli.

- **Przykład:**
  - Tabela `Classes` ma klucz główny `IdClass`, który jednoznacznie identyfikuje każdą klasę.
  - Tabela `PostCodes` ma klucz główny `IdPostCode`, który jednoznacznie identyfikuje każdy kod pocztowy.
  - Tabela `Adresses` ma klucz główny `IdAddress`, który jednoznacznie identyfikuje każdy adres.
  - Tabela `Users` ma klucz główny `IdUser`, który jednoznacznie identyfikuje każdego użytkownika.
  - Tabela `Students` ma klucz główny `IdStudent`, który jednoznacznie identyfikuje każdego ucznia.
  - Tabela `SchoolSubjects` ma klucz główny `IdSchoolSubject`, który jednoznacznie identyfikuje każdy przedmiot szkolny.
  - Tabela `Teachers` ma klucz główny `IdTeacher`, który jednoznacznie identyfikuje każdego nauczyciela.
  - Tabela `Lessons` ma klucz główny `IdLesson`, który jednoznacznie identyfikuje każdą lekcję.
  - Tabela `Grades` ma klucz główny `IdGrade`, który jednoznacznie identyfikuje każdą ocenę.
  - Tabela `Parents` ma klucz główny `IdParent`, który jednoznacznie identyfikuje każdego rodzica.
  - Tabela `Messages` ma klucz główny `IdMessage`, który jednoznacznie identyfikuje każdą wiadomość.
  - Tabela `Presences` ma klucz główny `IdPresence`, który jednoznacznie identyfikuje każdą obecność.
  - Tabela `PhoneNumbers` ma klucz główny `IdPhoneNumber`, który jednoznacznie identyfikuje każdy numer telefonu.

- **Klucze główne złożone:**
  - Tabela `TeachersTeachingSubjects` ma klucz główny złożony z `IdTeacher` i `IdSchoolSubject`, co jednoznacznie identyfikuje powiązanie nauczyciela z przedmiotem.
  - Tabela `ParentsStudentPairs` ma klucz główny złożony z `IdStudent` i `IdParent`, co jednoznacznie identyfikuje relację między uczniem a rodzicem.
  - Tabela `MessageUserReceiverPairs` ma klucz główny złożony z `IdMessage` i `IdUserReceiver`, co jednoznacznie identyfikuje odbiorcę wiadomości.
  - Tabela `PhoneNumbersParentsMatch` ma klucz główny złożony z `IdPhoneNumber` i `IdParent`, co jednoznacznie identyfikuje powiązanie numeru telefonu z rodzicem.

#### **Indeksy Unikalne (`UNIQUE INDEX`)**

- **Definicja:** Zapewniają, że wartości w określonych kolumnach są unikalne, zapobiegając duplikatom.

- **Przykład:**
  - `Login_UNIQUE` w tabeli `Users` gwarantuje, że każdy login jest unikalny.
  - `Email_UNIQUE` w tabeli `Users` gwarantuje, że każdy adres e-mail jest unikalny.
  - `IdUser_UNIQUE` w tabeli `Students` zapewnia, że dany użytkownik może być przypisany tylko do jednego ucznia.
  - `IdUser_UNIQUE` w tabeli `Teachers` zapewnia, że dany użytkownik może być przypisany tylko do jednego nauczyciela.
  - `IdUser_UNIQUE` w tabeli `Parents` zapewnia, że dany użytkownik może być przypisany tylko do jednego rodzica.
  - `PhoneNumber_UNIQUE` w tabeli `PhoneNumbers` gwarantuje, że każdy numer telefonu jest unikalny.

### **c. Klucze Obce i Integralność Referencyjna**

#### **Klucze Obce (`FOREIGN KEY`)**

- **Definicja:** Odniesienie do klucza głównego w innej tabeli, zapewniające spójność i integralność danych poprzez wymuszenie istnienia powiązanych rekordów.

- **Przykład:**

  - W tabeli `Adresses`:
    - `IdPostCode` jest kluczem obcym odnoszącym się do `PostCodes(IdPostCode)`.
    - **Jak to działa:** Zapewnia, że każdy adres jest powiązany z istniejącym kodem pocztowym.

  - W tabeli `Users`:
    - `IdAddress` jest kluczem obcym odnoszącym się do `Adresses(IdAddress)`.
    - **Jak to działa:** Gwarantuje, że każdy użytkownik ma przypisany istniejący adres.

  - W tabeli `Students`:
    - `IdUser` jest kluczem obcym odnoszącym się do `Users(IdUser)`.
    - `IdClass` jest kluczem obcym odnoszącym się do `Classes(IdClass)`.
    - **Jak to działa:** Upewnia się, że każdy uczeń jest powiązany z istniejącym użytkownikiem i klasą.

  - W tabeli `Teachers`:
    - `IdUser` jest kluczem obcym odnoszącym się do `Users(IdUser)`.
    - **Jak to działa:** Zapewnia, że każdy nauczyciel jest powiązany z istniejącym użytkownikiem.

  - W tabeli `Lessons`:
    - `IdSchoolSubject` jest kluczem obcym odnoszącym się do `SchoolSubjects(IdSchoolSubject)`.
    - `IdTeacher` jest kluczem obcym odnoszącym się do `Teachers(IdTeacher)`.
    - `IdClass` jest kluczem obcym odnoszącym się do `Classes(IdClass)`.
    - **Jak to działa:** Gwarantuje, że każda lekcja jest powiązana z istniejącym przedmiotem, nauczycielem i klasą.

  - W tabeli `Grades`:
    - `IdStudent` jest kluczem obcym odnoszącym się do `Students(IdStudent)`.
    - `IdTeacher` jest kluczem obcym odnoszącym się do `Teachers(IdTeacher)`.
    - `IdSubject` jest kluczem obcym odnoszącym się do `SchoolSubjects(IdSchoolSubject)`.
    - **Jak to działa:** Upewnia się, że każda ocena jest przypisana do istniejącego ucznia, nauczyciela i przedmiotu.

  - W tabeli `TeachersTeachingSubjects`:
    - `IdTeacher` jest kluczem obcym odnoszącym się do `Teachers(IdTeacher)`.
    - `IdSchoolSubject` jest kluczem obcym odnoszącym się do `SchoolSubjects(IdSchoolSubject)`.
    - **Jak to działa:** Zapewnia poprawne powiązanie nauczycieli z przedmiotami, które nauczają.

  - W tabeli `Parents`:
    - `IdUser` jest kluczem obcym odnoszącym się do `Users(IdUser)`.
    - **Jak to działa:** Gwarantuje, że każdy rodzic jest powiązany z istniejącym użytkownikiem.

  - W tabeli `ParentsStudentPairs`:
    - `IdStudent` jest kluczem obcym odnoszącym się do `Students(IdStudent)`.
    - `IdParent` jest kluczem obcym odnoszącym się do `Parents(IdParent)`.
    - **Jak to działa:** Umożliwia tworzenie relacji wielu do wielu między uczniami a rodzicami.

  - W tabeli `Messages`:
    - `IdUserSender` jest kluczem obcym odnoszącym się do `Users(IdUser)`.
    - **Jak to działa:** Każda wiadomość jest powiązana z istniejącym użytkownikiem jako nadawcą.

  - W tabeli `MessageUserReceiverPairs`:
    - `IdMessage` jest kluczem obcym odnoszącym się do `Messages(IdMessage)`.
    - `IdUserReceiver` jest kluczem obcym odnoszącym się do `Users(IdUser)`.
    - **Jak to działa:** Umożliwia powiązanie wiadomości z wieloma odbiorcami.

  - W tabeli `Presences`:
    - `IdLesson` jest kluczem obcym odnoszącym się do `Lessons(IdLesson)`.
    - `IdStudent` jest kluczem obcym odnoszącym się do `Students(IdStudent)`.
    - **Jak to działa:** Rejestruje obecność uczniów na konkretnych lekcjach, zapewniając spójność danych.

  - W tabeli `PhoneNumbersParentsMatch`:
    - `IdPhoneNumber` jest kluczem obcym odnoszącym się do `PhoneNumbers(IdPhoneNumber)`.
    - `IdParent` jest kluczem obcym odnoszącym się do `Parents(IdParent)`.
    - **Jak to działa:** Łączy numery telefonów z rodzicami, zapewniając, że numery są przypisane do istniejących rodziców.

- **Jak to działa ogólnie:** Klucze obce wymuszają integralność referencyjną, co oznacza, że nie można dodać rekordu do tabeli zależnej bez istnienia odpowiadającego rekordu w tabeli głównej. Zapobiega to niespójnym danym i utrzymuje integralność bazy danych.

## 3. **Kontrola Dostępu do Danych**

### **a. Uwierzytelnianie Użytkowników**
- **Mechanizm Logowania:**
  - Użytkownicy logują się do systemu za pomocą unikalnego `Login` i `HashedPassword`.
  - **Bezpieczeństwo:** Hasła są przechowywane w postaci zaszyfrowanej (`HashedPassword`), co chroni je przed nieautoryzowanym dostępem.

### **b. Autoryzacja i Role Użytkowników**

Każdy użytkownik systemu ma przypisaną rolę, która definiuje, do jakich funkcji i danych ma dostęp. Role są definiowane w kolumnie `Role` w tabeli `Users` jako `ENUM`. Poniżej przedstawiam, jakie uprawnienia mają poszczególne role:

#### **1. Użytkownik (Ogólne Uprawnienia)**
- **Funkcje:**
  - Odczytywanie wiadomości.
  - Wysyłanie wiadomości.
- **Uprawnienia:**
  - **SELECT:** Dostęp do tabeli `Messages` oraz `MessageUserReceiverPairs` w zakresie odczytu wiadomości.
  - **INSERT:** Dodawanie nowych wiadomości do tabeli `Messages` oraz tworzenie powiązań w `MessageUserReceiverPairs`.

#### **2. Uczeń (ENUM('student'))**
- **Funkcje:**
  - Przeglądanie swoich ocen.
  - Przeglądanie swoich średnich.
  - Przeglądanie swoich obecności.
  - Przeglądanie swojego planu lekcji.
- **Uprawnienia:**
  - **SELECT:** Dostęp do tabel `Grades`, `Presences`, `Lessons` w zakresie tylko swoich danych.
  - **SELECT:** Dostęp do swoich rekordów w tabeli `Users`.

#### **3. Rodzic(ENUM('parent'))**
- **Funkcje:**
  - Wszystko, co uczeń.
  - Usprawiedliwianie nieobecności swojego dziecka.
- **Uprawnienia:**
  - **SELECT:** Dostęp do danych dziecka w tabelach `Grades`, `Presences`, `Lessons`.
  - **UPDATE:** Możliwość aktualizacji wpisów obecności swojego dziecka w tabeli `Presences`.

#### **4. Nauczyciel(ENUM('teacher'))**
- **Funkcje:**
  - Zarządzanie obecnościami.
  - Zarządzanie ocenami.
- **Uprawnienia:**
  - **SELECT, INSERT, UPDATE:** Dostęp do tabel `Grades` i `Presences` w zakresie przypisanych im przedmiotów i klas.
  - **SELECT:** Dostęp do tabel `Students` i `Lessons` dla swoich klas.

#### **5. Dyrektor(ENUM('headmaster'))**
- **Funkcje:**
  - Wszystko, co nauczyciel.
  - Wszystko, co administrator danych.
  - Zarządzanie przedmiotami.
  - Zarządzanie lekcjami.
- **Uprawnienia:**
  - **SELECT, INSERT, UPDATE, DELETE:** Dostęp do wszystkich tabel związanych z ocenami, obecnościami, przedmiotami i lekcjami.
  - **SELECT, INSERT, UPDATE, DELETE:** Dostęp do tabel `Users`, `Classes`, `SchoolSubjects`, `Lessons`.

#### **6. Administrator Danych(nie jako rola ale jako część wspólna uprawnień dyrektora i administratora technicznego)**
- **Funkcje:**
  - Zarządzanie użytkownikami.
- **Uprawnienia:**
  - **SELECT, INSERT, UPDATE, DELETE:** Dostęp do tabel `Users`, `Students`, `Parents`, `Teachers`, oraz powiązanych tabel.

#### **7. Administrator TechnicznyENUM('admin')**
- **Funkcje:**
  - Wszystko, co administrator danych.
  - Zarządzanie kopiami zapasowymi.
- **Uprawnienia:**
  - **SELECT, INSERT, UPDATE, DELETE:** Dostęp do wszystkich tabel, które może mieć administrator danych.
  - **Operacje na bazie danych:** Uprawnienia do tworzenia kopii zapasowych, przywracania danych, zarządzania użytkownikami bazy danych.

### **c. Kontrola Dostępu na Poziomie Bazy Danych**

#### **1. Użytkownicy Bazy Danych**
- **Definicja:** Oddzielne konta dla różnych typów użytkowników systemu z przypisanymi odpowiednimi uprawnieniami.
- **Przykład:**
  - Konto `student_user` ma uprawnienia tylko do odczytu swoich ocen i obecności.
  - Konto `teacher_user` ma uprawnienia do wprowadzania i modyfikowania ocen oraz obecności swoich uczniów.

#### **2. Uprawnienia SQL**
- **SELECT:** Umożliwia odczyt danych z tabel.
- **INSERT:** Pozwala na dodawanie nowych rekordów do tabel.
- **UPDATE:** Umożliwia modyfikowanie istniejących rekordów.
- **DELETE:** Pozwala na usuwanie rekordów z tabel.

**Przykład:** 
- Administrator danych może mieć przyznane wszystkie uprawnienia (`SELECT`, `INSERT`, `UPDATE`, `DELETE`) na tabeli `Users`, co pozwala mu na zarządzanie użytkownikami.
- Uczeń ma tylko `SELECT` na tabelach `Grades` i `Presences`, co pozwala mu na przeglądanie swoich ocen i frekwencji, ale nie na ich modyfikację.

### **d. Ograniczenia Fizyczne i Sieciowe**

#### **1. Dostęp do Serwera**
- **Opis:** Ograniczenie fizycznego dostępu do serwera bazy danych tylko dla uprawnionych osób.
- **Przykład:** Serwer bazy danych znajduje się w zabezpieczonym pomieszczeniu, do którego mają dostęp tylko administratorzy techniczni.

#### **2. Zapory Sieciowe (Firewalls)**
- **Opis:** Konfiguracja zapór sieciowych w celu ograniczenia dostępu do bazy danych tylko dla zaufanych adresów IP.
- **Przykład:** Zapora sieciowa blokuje wszystkie połączenia z zewnątrz, pozwalając tylko na połączenia z wewnętrznej sieci szkolnej.

### **e. Backup i Odzyskiwanie Danych**

#### **1. Regularne Kopie Zapasowe**
- **Opis:** Tworzenie regularnych kopii zapasowych bazy danych w celu ochrony przed utratą danych.
- **Przykład:** Codzienny backup bazy danych jest wykonywany i przechowywany w bezpiecznym miejscu, co umożliwia przywrócenie danych w przypadku awarii.

#### **2. Plany Odzyskiwania**
- **Opis:** Opracowanie procedur odzyskiwania danych w przypadku awarii systemu lub ataku.
- **Przykład:** W przypadku awarii serwera, zespół IT ma przygotowany plan, który obejmuje przywrócenie bazy danych z ostatniej kopii zapasowej i minimalizację przestojów.
