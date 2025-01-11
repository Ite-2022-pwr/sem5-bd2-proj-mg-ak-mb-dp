
# POLITECHNIKA WROCŁAWSKA
# WYDZIAŁ INFORMATYKI I TELEKOMUNIKACJI
---
# PROJEKT Z BAZ DANYCH
## DZIENNIK ELEKTRONICZNY *Gejzer*
---

### Termin zajęć:
- Środa, 11:15-13:00

### Autorzy:
- Miłosz Bedryło 272934
- Artur Kręgiel 272989
- Dominik Pokrzywa 272953
- Mateusz Głuchowski 272885

### Prowadzący:
- dr inż. Roman Ptak, W4
---

Wrocław, 2025 r.

---
# Spis treści
- TO DO

---
# 1. Wstęp
## 1.1 Cel projektu
- Projekt ma na celu stworzenie systemu, który ułatwi zarządzanie danymi, nauczania, komunikacją w szkole. Baza danych będzie centralnym elementem systemu, aplikacja dostępowa oferująca różne funkcje dla uczniów, rodziców, nauczycieli oraz administracji.
---
## 1.2 Zakres projektu
- Zakresem naszego projektu będzie realizacja systemu dziennika, jako aplikacja webowa korzystająca z frameworków: spring boot, react, chakra ui. Jako baza danych dla naszego projektu zostanie użyty PostgreSQL.
---

# 2. Analiza wymagań
- W ramach przygotowania do realizacji projektu, przeprowadzona została analiza wymagań użytkowników dziennika online, polegała ona na przeanalizowaniu rozwiązań znanych nam osobiście ze szkół średnich oraz ustaleniu zakresu naszego projektu.
## 2.1 Opis działania i schemat logiczny systemu
---
- System będzie działał jako aplikacja webowa składająca się z oddzielnego backendu i frontendu komunikujących się przy pomocy REST API, a bezpośredni dostęp do bazy danych ma tylko backend, który dba też o autentykację użytkowników.
	![[Pasted image 20250109203833.png]]
	*Rysunek 1. Schemat logiczny systemu.*
## 2.2 Wymagania funkcjonalne
---
- Panel ucznia 
	- możliowść przeglądania planu lekcji 
	- możliwość przeglądania zapowiedzianych sprawdzianów, kartkówek
	- możliwosć przeglądania ocen oraz średniej 
	- możliwość przeglądania obecności na lekcjach 
	- otrzymywanie i przeglądanie wiadomości od nauczyciela 

- Panel rodzica 
	- posiada pełną funkcjonalność ucznia 
	- możliowść przełączania między dziećmi
	- mozliwość wysłania usprawiedliwienia 
	- możliwość korespondowania z nauczycielem 

- Panel nauczyciela 
	- możliowść wglądu do planów lekcji 
	- uzupełnianie oraz przeglądanie listy obecności 
	- wystawianie ocen 
	- wysyłanie ogłoszeń 
	- prowadzenie korespondecji z rodzicami (crud) 

- Panel dyrektora (administrator merytoryczny) 
	- dodaj usuń edytuj (uczniow nauczycieli rodziców ) 
	- umieszczanie ogloszenia dla wszystkich (nauczyciel, rodzic, uczeń) 
	- resetowanie haseł 
	- Panel administratora (administrator techniczny) 
	- wgląd do całości systemu

## 2.3 Wymagania niefunkcjonalne
---
### 2.3.1 Wykorzystywane technologie i narzędzia
### 2.3.2 Wymagania dotyczące rozmiaru bazy danych
### 2.3.3 Wymagania dotyczące bezpieczeństwa systemu

## 2.4 Przyjęte założenia projektowe
---
# 3. Projekt systemu
- Projekt i struktury bazy danych, mechanizmów zapewniania poprawności przechowywanych informacji, oraz kontroli dostępu do danych.
## 3.1 Projekt bazy danych
---
### 3.1.1 Analiza rzeczywistości i uproszczony model konceptualny
### 3.1.2 Model logiczny i normalizacja
### 3.1.3 Model fizyczny i ograniczenia integralności danych
### 3.1.4 Inne elementy schematu - mechanizmy przetwarzania danych
### 3.1.5 Projekt mechanizmów bezpieczeństwa na poziomie bazy danych

## 3.2 Projekt aplikacji użytkownika
--- 
### 3.2.1 Architektura aplikacji i struktura ~~menu~~ UI
- W projekcie została wykorzystana reguła architektura REST. Ma na celu odseparowanie interfejsu użytkownika od operacji na serwerze. Dodatkowo zachowujemy bezstanowość poprzez wymaganie uwierzytelnienia użytkownika przy każdym zapytaniu. Kolejnym elementem wykorzystanym w projekcie jest separacja warstw. Odziela się logikę biznesową oraz prezentacji od warstwy dostępu do danych. 
 
### 3.2.2. Interfejs graficzny i struktura ~~menu~~ UI
- TO DO

### 3.2.3 Projekt wybranych funkcji systemu

### 3.2.4 Metoda podłączania do bazy danych
- W projekcie używamy **ORM** (*Hibernate*) przy założeniu **Database First**.  
### 3.2.5 Projekt zabezpieczeń na poziomie aplikacji
# 4. Implementacja systemu baz danych
- Implementacja i testy bazy danych w wybranym systemie zarządzania bazą danych.
## 4.1 Tworzenie tabel i definiowanie ograniczeń
---

## 4.2 Implementowanie machanizmów przetwarzania danych
---

## 4.3 Implementacja uprawnień i innych zabezpieczeń
---

## 4.4 Testowanie bazy danych na przykładowych danych
---

# 5. Implementacja i testy aplikacji
- Skrócone sprawozdanie z etapu implementacja i testowania aplikacji.

## 5.1 Instalacja ikonfigurowanie systemu
---

## 5.2 Instrukcja użytkowania aplikacji
---

## 5.3 Testowanie opracowanych funkcji systemu
---

## 5.4 Omówienie wybranych rozwiązań programistycznych
---
### 5.4.1 Implementacja interfejsu dostępu do bazy danych

### 5.4.2 Implementacja wybranych funkcjonalności systemu

# 6. Źródła
---
- https://github.com/Ite-2022-pwr
- https://github.com/Ite-2022-pwr/sem5-bd2-proj-mg-ak-mb-dp
- https://devszczepaniak.pl/wprowadzenie-do-rest-api/
