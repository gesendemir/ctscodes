#include <iostream>
using namespace std;

//void initializeDList(DList & dl);
//void put(DList& dl, int val);
//bool get(DList& dl, int &val);


typedef int ListType;

struct DListElem{
    ListType data;
    DListElem *prev;
    DListElem *next;
};


struct DList{
    DListElem * first = new DListElem;
    DListElem * last = new DListElem;
};

bool isEmpty(DList dl){
    if(dl.first->next == dl.last->prev){
        if(dl.first->next == nullptr) return true;
   }return false;
}

void initializeDList(DList & dl){
    dl.first->next = nullptr;
    dl.first->data = NULL;
    dl.last->prev = nullptr;
    dl.last->data = NULL;
}

void put(DList& dl, int val){
    DListElem * newAdd = new DListElem;
    
    newAdd->data = val;
    newAdd->next = nullptr;
    if(dl.first-> next == dl.last-> prev ){
        if(dl.first-> next == nullptr){
            dl.first-> next = newAdd;
            dl.last->prev = newAdd;
            newAdd->prev = nullptr;
            
        }else{
            DListElem * temp;
            temp = dl.first->next;
            temp->next = newAdd;
            newAdd->prev = temp;
            dl.first->next = temp;
            dl.last->prev=newAdd;
            
        }
    }else{
        DListElem * temp;
        temp= dl.last->prev;
        temp->next = newAdd;
        newAdd->prev= temp;
        dl.last->prev = newAdd;
        
    }

}

bool get(DList& dl, int &val){
    if(!isEmpty(dl)){
        if(dl.first->next == dl.last->prev){
        DListElem * temp;
        temp = dl.last->prev;
        val = temp->data;
        delete dl.last->prev;
      //  dl.last->prev = temp->prev; 
        initializeDList(dl);
        }else{
        DListElem * temp;
        temp = dl.last->prev;
        val = temp->data;
        delete dl.last->prev;
        dl.last->prev = temp->prev; 
        }
        
        return true;
    
    }return false;

}





int main() {
    DList queue;

  initializeDList(queue);

  //insert 5 values
  for (int i = 1; i <= 5; i++) {
    cout << "put: " << 10 * i << endl;
    put(queue, 10 * i);
  }

  //remove 3 values and print them to console
  for (int j = 1; j <= 3; j++) {
    int value;
    if (get(queue, value))
       cout << "     get: " << value << endl;
  }

 // cout << "Laenge: " << dlistLength(queue) << endl;
  
  //insert 5 values 
  for (int i = 6; i <= 10; i++) {
    cout << "put: " << 10 * i << endl;
    put(queue, 10 * i);
  }

 // cout << "Laenge: " << dlistLength(queue) << endl;

  //remove all values and print them
  while(!isEmpty(queue)) {
    int value;
    get(queue, value);
    cout << "     get: " << value << endl;
  }
}
