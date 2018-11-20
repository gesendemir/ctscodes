#include <iostream>
#include <fstream>
#include "Stock.h"
#include "Article.h"



Stock::Stock(){
    int articleNumber;
    int actualStock;
    int maximumStock; 
    int consumption;
}
Stock::Stock(int articleNumber, int actualStock, int maximumStock, int consumption){
    int number = articleNumber;
    int actstock = actualStock;
    int maxstock = maximumStock; 
    int cons = consumption;
}
void Stock::setArticleNumber(int num){
    articleNumber = num;
}

void Stock::setActualStock(int actstock){
    actualStock = actstock;
}

void Stock::setMaximumStock(int maxstock){
    maximumStock = maxstock;
}


void Stock::setConsumption(int cons){
    consumption = cons;
}

int Stock::getArticleNumber(){
    return articleNumber;
}
int Stock::getStock(){
    return actualStock;
}
int Stock::getMaximumStock(){
    return maximumStock;
}
int Stock::getConsumption(){
    return consumption;
}

int Stock::readData(Stock list[], char *sourcefile, int pos){
    char buffer[90];
    std::fstream source(sourcefile);
    if(!source.is_open()){
        std::cerr << "Error When Opening! : " << sourcefile <<std::endl;
        exit(-1);
    }
    while(!source.getline(buffer, 90).eof() ){
        source.get(buffer, 6);
      //  std::cout << atoi(buffer) << std::endl;
        list[pos].setArticleNumber(atoi(buffer));
        
        source.get(buffer, 14);
      //  std::cout << buffer << std::endl;
        list[pos].Article::setDescription(*buffer);

        source.get(buffer, 6);
       // std::cout << atoi(buffer) << std::endl;
        list[pos].setActualStock(atoi(buffer));

        source.get(buffer, 6);
       // std::cout << atoi(buffer) << std::endl;
        list[pos].setMaximumStock(atoi(buffer));

        source.get(buffer, 16);
       // std::cout << atof(buffer) << std::endl;
        list[pos].Article::setCostPrice(atof(buffer));


        source.get(buffer, 6);
      //  std::cout << atoi(buffer) << std::endl;
        list[pos].setConsumption(atoi(buffer));

        source.get(buffer, 6);
      //  std::cout << atoi(buffer) << std::endl;
        list[pos].Article::setOrderDuration(atoi(buffer));
        
        // std::cout << list[pos] << std::endl;
        pos++;
    }
    source.close();
    return pos;
}

Stock::~Stock(){
}

