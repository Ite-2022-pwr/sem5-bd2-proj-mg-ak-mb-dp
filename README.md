# Bazy danych 2 - projekt

## Skład grupy

- [Miłosz Bedryło](https://github.com/lolex565)
- [Mateusz Głuchowski](https://github.com/hue1337)
- [Artur Kręgiel](https://github.com/arkregiel)
- [Dominik Pokrzywa](https://github.com/serrwo)

## Opis słowny systemu - Dziennik szkolny

Projekt ma na celu stworzenie systemu dziennika elektronicznego, który ułatwi:
- zarządzanie uczniami
- zarządzanie planem lekcji
- zarządzanie ocenami
- komunikację między nauczycielami a rodzicami i uczniami

Centralnym elementem systemu będzie **baza danych**.

Interakcja z bazą danych będzie możliwa dzięki **aplikacji dostępowej**, która zostanie zaimplementowana jako **aplikacja webowa** zgodnie ze wzorcem [MVC](https://pl.wikipedia.org/wiki/Model-View-Controller).

## Wymagania funkcjonalne

- **Panel ucznia**
    - możliowść przeglądania planu lekcji
    - możliwość przeglądania zapowiedzianych sprawdzianów, kartkówek 
    - możliwosć przeglądania ocen oraz średniej
    - możliwość przeglądania obecności na lekcjach
    - otrzymywanie i przeglądanie wiadomości od nauczyciela
 
- **Panel rodzica**
    - posiada pełną funkcjonalność ucznia
    - możliowść przełączania między swoimi dziećmi 
    - mozliwość usprawiedliwiania nieobecności ucznia (dziecka)
    - możliwość prowadzenia korespondecji z nauczycielem (CRUD)
 
- **Panel nauczyciela**
    - możliowść wglądu do planów lekcji 
    - możliwość uzupełniania oraz przeglądania listy obecności 
    - możliwość wystawiania ocen
    - możliwość wysyłania ogłoszeń do uczniów i rodziców
    - możliwość prowadzenia korespondecji z rodzicami oraz innymi nauczycielami (CRUD)
 
- **Panel dyrektora (administrator merytoryczny)**
    - dodawanie, usuwanie, edytowanie: 
        - uczniow,
        - nauczycieli, 
        - rodziców
    - możliowść wglądu do planów lekcji
    - możliwość wysyłania ogłoszeń do rodziców oraz uczniów
    - możliwość prowadzenia korespondecji z rodzicami oraz nauczycielami (CRUD)

- **Panel administratora (administrator techniczny)**
    - posiadanie pełnej kontroli nad systemem


## Wymagania niefunkcjonalne

System zostanie zaimplementowany jako **aplikacja** webowa zgodnie ze wzorcem [MVC](https://pl.wikipedia.org/wiki/Model-View-Controller).

### Wykorzystywane technologie i narzędzia

- **Baza danych**
    - [PostgreSQL](https://www.postgresql.org/)

- **Backend**
    - język programowania: [Java](https://www.java.com/pl/)
    - biblioteki oraz frameworki:
        - [Spring Boot](https://spring.io/projects/spring-boot)
        - [Hibernate](https://hibernate.org/)
        - [Lombok](https://projectlombok.org/)

- **Frontend**
    - język programowania: [TypeScript](https://www.typescriptlang.org/)
    - biblioteki:
        - [React](https://react.dev/)
        - [ChakraUI](https://v2.chakra-ui.com/)

### Wymagania dotyczące rozmiaru bazy danych

Przyjmując przykładową szkołę podstawową z 8 rocznikami, gdzie każdy ma dwie 25 osobowe klasy, najbardziej licznymi encjami okazały się wpisy obecności oraz oceny.

Pozostałe założenia do oszacowania to średnio 5 lekcji dziennie, oraz to że uczeń średnio w tygodniu roboczym. dostaje 3 oceny

Wygenerowane przez użytkowników w ciągu jednego semestru mającego 90 dni roboczych wpisy obecności same zajmą około 200 tys. rekordów, a oceny około 22 tys.

![image](https://github.com/user-attachments/assets/c0835f1b-672e-4998-ba6a-7cc45706070f)


### Wymagania dotyczące bezpieczeństwa systemu

Podstawowym mechanizmem bezpieczeństwa zapewniającym uwierzytelnienie użytkownika będzie konieczność podania nazwy użytkownika oraz hasła podczas logowania. Użytkownik niezaogowany nie będzie miał dostępu do systemu.

Hasła użytkowników, aby utrudnić uzyskanie nieautoryzowanego dostępu do aplikacji, muszą składać się z co najmniej 8 znaków oraz zawierać:
- małą literę
- wielką literę
- cyfrę
- znak specjalny

Hasła w bazie danych będą haszowane z użyciem algorytmu SHA256.

Autoryzacja zalogowanych użytkowników będzie bazowała na uprawnieniach dla konkretnych ról użytkowników: uczeń, rodzic, nauczyciel, administrator merytoryczny, administrator techniczny. Przykładowo, uczeń i rodzic nie będą mogli modyfikować planu lekcji, ocen oraz obecności.

Zastosowanie wyżej wymienionych bibliotek przy implementacji aplikacji dostępowej uniemożliwi przeprowadzenie ataków takich jak SQL injcection oraz Cross-Site Scripting.
