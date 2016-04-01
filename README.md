# Zadanie rekrutacyjne - rozszerzone rozwiązanie

### 1. Opis i cel zadania
1. odczytanie zawartości pliku tekstowego, który zawiera dane w ustalonym formacie
2. na podstawie zawartości pliku wypisać statystyki kwot w nim zapisanych
3. zadanie MUSI zostać wykonane z wykorzystaniem języka Java

### 2. Opis pliku wejściowego
1. Kodowanie pliku to utf-8
2. Każda linia w pliku zawiera informacje o jednej transakcji
3. Każda transakcja zawiera informacje o:
    *  osobie inicjującej transakcję (imię, nazwisko)
    *  konto źródłowe, konto docelowe
    *  kwocie transakcji z informacją o walucie (PLN)
4. Informacje zapisane w każdej linijce mają następujący format:
    *  znak '@' (tzw. małpa) - oznaczający początek pary klucz:wartość, gdzie kluczem jest nazwa pola
    *  po znaku inicjującym, znajduje się klucz, który jest jedną z wartości:
        *  name
        *  surname
        *  src_iban
        *  dst_iban
        *  amount
    *  po kluczu znajduje się znak ':' (dwukropek), oddzielający klucz od wartości
    *  po znaku ':' znajduje się wartość pola
    *  przykładowa linijka będzie miała następującą formę: @name:Jan@surname:Kowalski@src_iban:84063099651078062132711059@dst_iban:16612843863420872434731304@amount:12,34PLN