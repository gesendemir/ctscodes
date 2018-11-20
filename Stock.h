#ifndef STOCK_H_
#define STOCK_H_
#include <iostream>
#include "Article.h"

class Stock : public Article
{
    private:
        int articleNumber;
        int actualStock;
        int maximumStock; 
        int consumption;
        void setArticleNumber(int num);
        void setActualStock(int actstock);
        void setMaximumStock(int maxstock);
        void setConsumption(int cons);
  
    public:
        Stock();
        Stock(int articleNumber, int actualStock, int maximumStock, int consumption);
        int getArticleNumber();
        int getStock();
        int getMaximumStock();
        int getConsumption();
        int readData(Stock list[], char *sourcefile, int pos);
        ~Stock(); 
};
#endif