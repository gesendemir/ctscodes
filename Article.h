#ifndef ARTICLE_H_
#define ARTICLE_H_
#include <iostream>

class Article{
    public:
        int numberOfArticel;
        char description;
        float costPrice;
        int orderDuration;
        Article();
        Article(char &description, float costPrice, int orderDuration, const int numberOfArticel = 10000);
        ~Article();
        char * getDescription(){ return &description; };
        float getCostPrice(){return costPrice;};
        int getOrderDuration() {return orderDuration;};

    protected:
        
        void setDescription(char &desc);
        void setCostPrice(float cost);
        void setOrderDuration(int ord);
};

#endif