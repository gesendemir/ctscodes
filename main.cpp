#include <iostream>
#include "Stock.h"
#include "Article.h"



int main() {
    int listcount = 5;
    Stock * listofstocks = new Stock[listcount];
    listofstocks->readData(listofstocks, "filename.txt", 0);
    for(int i = 0; i < listcount; i++){
        Stock temp = listofstocks[i];
        std::cout << temp.getArticleNumber() << "\t" << temp.getDescription() << std::endl;
    }
    
}