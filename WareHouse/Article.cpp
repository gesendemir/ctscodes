#include <iostream>
#include "Stock.h"
#include "Article.h"


Article::Article(){
}
Article::Article(char &description, float costPrice, int orderDuration, const int numberOfArticel){
    int m_numberOfArticel = numberOfArticel;
    char *m_description = &description;
    float m_costPrice = costPrice;
    int m_orderDuration = orderDuration;
}


void Article::setDescription(char &desc){
    description = desc;
}

void Article::setCostPrice(float cost){
    costPrice = cost;
}
void Article::setOrderDuration(int ord){
    orderDuration = ord;
}
        

Article::~Article(){

}
