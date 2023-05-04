package com.example.pamo2023;

public class Questions {
    public String questions[]={
            "Ile posiłków dziennie powinno się spożywać?",
            "Ile litrów wody powinno się pić w ciągu dnia?",
            "Który z posiłków jest najważniejszy?",
            "Co ile godzin powinno się spożywać posiłki?",
            "Ile godzin snu potrzebuje przecietny człowiek?",
            "Kiedy najlepiej spożyć ostatni posiłek przed snem?",
            "W jakim wieku szczególnie powinno się przestrzegać zasad zdrowego odżywiania się?",
            "Czym najlepiej ugasić pragnienie po wysiłku fizycznym?",
            "Jak należy jeść prawidłowo?"
    };
    public String[][] choices={
            {"Dwa","Cztery","Pięć"},
            {"1 Litr","1,5 Litrów","2 Litry"},
            {"Śniadanie","Obiad","Kolacja"},
            {"1-2","2-3","3-4"},
            {"4-6","7-8","9-10"},
            {"Dwie godziny przed snem.","Kiedy ma się na to ochotę.","Cztery godziny przed snem."},
            {"W wieku dziecięcym.","W wieku młodzieńczym.","W dorosłości i w wieku starszym."},
            {"Niegazowaną wodą mineralną","Sokiem.","Kawą."},
            {"Szybko przeżuwać.","Dokładnie przeżuwać i rozdrabniać pokarm.","Popijać bez gryzienia."}
    };
    public String correctAnswer[]={
            "Pięć","1,5 Litrów","Śniadanie","3-4","7-8","Dwie godziny przed snem.",
            "W wieku młodzieńczym.","Niegazowaną wodą mineralną","Dokładnie przeżuwać i rozdrabniać pokarm."
    };
    public String getQuestion(int x){
        String question=questions[x];
        return question;
    }
    public String getchoice1(int x){
        String choice=choices[x][0];
        return choice;
    }
    public String getchoice2(int x){
        String choice=choices[x][1];
        return choice;
    }
    public String getchoice3(int x){
        String choice=choices[x][2];
        return choice;
    }
    public String getCorrectAnswer(int x){
        String answer=correctAnswer[x];
        return answer;
    }
}
