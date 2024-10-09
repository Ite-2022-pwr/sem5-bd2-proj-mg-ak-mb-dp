# Bazy danych 2 - projekt

## Skład grupy

- [Miłosz Bedryło](https://github.com/lolex565)
- [Mateusz Głuchowski](https://github.com/hue1337)
- [Artur Kręgiel](https://github.com/arkregiel)
- [Dominik Pokrzywa](https://github.com/serrwo)

## Opis słowny systemu - Dziennik szkolny

Projekt ma na celu stworzenie systemu, który ułatwi zarządzanie danymi, nauczania, komunikacją w szkole. Baza danych będzie centralnym elementem systemu, aplikacja dostępowa oferująca różne funkcje dla uczniów, rodziców, nauczycieli oraz administracji.

### Funkcjonalność

- **Panel ucznia**
    - możliowść przeglądania planu lekcji
    - możliwość przeglądania zapowiedzianych sprawdzianów, kartkówek 
    - możliwosć przeglądania ocen oraz średniej
    - możliwość przeglądania obecności na lekcjach
    - otrzymywanie i przeglądanie wiadomości od nauczyciela
 
- **Panel rodzica**
    - posiada pełną funkcjonalność ucznia
    - możliowść przełączania między dziećmi 
    - mozliwość wysłania usprawiedliwienia
    - możliwość korespondowania z nauczycielem
 
- **Panel nauczyciela**
    - możliowść wglądu do planów lekcji 
    - uzupełnianie oraz przeglądanie listy obecności 
    - wystawianie ocen
    - wysyłanie ogłoszeń
    - prowadzenie korespondecji z rodzicami (crud)
 
- **Panel dyrektora (administrator merytoryczny)**
    - dodaj usuń edytuj (uczniow nauczycieli rodziców )
    - umieszczanie ogloszenia dla wszystkich (nauczyciel, rodzic, uczeń) 
    - resetowanie haseł 

- **Panel administratora (administrator techniczny)**
    - wgląd do całości systemu


## Technologia

### Baza danych

- PostgreSQL

### Backend

- Java + Spring Boot + Hibernate + Lombok

### Frontend

- TypeScript + React + ChackraUI

## To do:
- Aplikacja webowa - dodanie informacji
- Szacowanie licznośći - najwięcej encji (oceny)
- Autoryzacja (najpopularniejszy sposób autoryzacji)