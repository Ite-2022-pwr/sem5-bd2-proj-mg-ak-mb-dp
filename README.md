# Bazy danych 2 - projekt

## Opis słowny systemu - Dziennik szkolny

Projekt ma na celu stworzenie systemu, który ułatwi zarządzanie danymi i komunikację w szkole. Baza danych będzie centralnym elementem systemu, oferując różne funkcje dla uczniów, rodziców, nauczycieli oraz administracji.

### Funkcjonalność

- **Panel ucznia**
    - widok planu lekcji
    - widok zapowiedzianych sprawdzianów, kartkówek 
    - widok ocen oraz średniej
    - widok obecności na lekcjach
 
- **Panel rodzica**
    - wgląd do widoku ucznia (fukncjonalność panelu ucznia z widokami)
    - mozna przełączać między dziećmi 
    - mozliwosc wysłania usprawiedliwienia
 
- **Panel nauczyciela**
    - wgląd do planu lekcji
    - uzupełnianie oraz przeglądanie listy obecności 
    - wystawianie ocen
    - wysylanie ogłoszeń
 
- **Panel administratora**
    - dodaj usuń edytuj (uczniow nauczycieli rodziców )
    - umieszczanie ogloszenia dla wszystkich (nauczyciel, rodzic, uczeń) 
    - resetowanie haseł 

## Technologia

### Baza danych

- PostgreSQL

### Backend

- Java + Spring Boot + Hibernate + Lombok

### Frontend

- TypeScript + React + ChackraUI