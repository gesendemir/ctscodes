/*
 * Hasan Guney Esendemir
 * CTS 3
 * Matrikel Nummer: 3125737
 * Vigenere Cipher - Encryption And Decryption
 * 21.10.2018
 * 
 */

#include <iostream>
#include <string>
#include <locale>


using namespace std;

// Check methods for valid Text and Password.
// Encryption and Decryption Methods.

bool tcheck(string text){
    int x = text.length();
    //Check every letter of the text; if there is a lowercase letter return false.
    for(int i = 0; i < x; i++){
        if(isupper(text[i])){
            cout << "text must be all lower case!" << endl;
            return false;
        }

    }return true;
}

bool kcheck(string key){
    int x = key.length();
    //Check every letter of the key; if there is a capital letter return false.
    for(int i = 0; i < x; i++){
        if(islower(key[i])){
            cout << "KEY MUST BE ALL UPPER CASE!" << endl;
            return false;
        }
    }return true;
    
}

string Encrypt(string text, string key){
    int j = 0;
    int txlength = text.length();
    int keyln = key.length();
    //Shift every letter to encrypt.
    for(int i=0; i < txlength ; i++){
            // If there is a space, do not encrypt.
            if(text[i] == char(' ')){
                continue;
            }else{
                //Calculate the shifted char. 
                //65 = ASCII value of 'A'; We will use it to shift down to 0.
                //New ASCII value for the letter = Current ASCII value + (Current Key Value - 65)
                int shiftedvalue = char(text[i]) + (char(key[j]) - 65);
                //If new char goes beyond Z, go back to A.
                if(shiftedvalue> 122){
                    shiftedvalue = shiftedvalue - 26;
                }
                //Replace the char.
                text[i] = char(shiftedvalue);
               // cout << text[i];
                j++;
                //If text is longer than keyword, go back to start of keyword.
                if(j == keyln){
                    j = 0;
                }
            }
            
        }
    return text;
}

string Decrypt(string text, string key){
    int j = 0;
    int txlength = text.length();
    int keyln = key.length();
    //Shift every letter to decrypt..
    for(int i=0; i < txlength ; i++){
            if(text[i] == char(' ')){
                continue;
            }else{
                //Calculate the shifted char. 
                //65 = ASCII value of 'A'; We will use it to shift down to 0.
                //New ASCII value for the letter = Current ASCII value - (Current Key Value - 65)
                int shiftedvalue = char(text[i]) - (char(key[j]) - 65);
                if(shiftedvalue < 97 ){
                    shiftedvalue = shiftedvalue + 26;
                }
                text[i] = char(shiftedvalue);
               // cout << text[i];
                j++;
                if(j == keyln){
                    j = 0;
                }
            }
            
        }
    return text;
}

int main(int argc, char const *argv[]){
// Take input from console.
 
    //Console Input Check
    if(argc != 4){
        cout << "Usage for Encryption: ./filename -e 'Text To Encrypt' 'Key' " << endl;
        cout << "Usage for Decryption: ./filename -d 'Text To Decrypt' 'Key' " << endl;
     
        
    }else if(string(argv[1]) == "-e"){
    
        //Check for encrytion flag from the console.
        //If text is all lowercase and password is all uppercase; encrypt.
        if(tcheck(argv[2]) && kcheck(argv[3])){
            cout << Encrypt(argv[2], argv[3]) << endl;    
        }
        
        
    }else if(string(argv[1]) == "-d"){
    
        //Check for encrytion flag from the console.
        //If text is all lowercase and password is all uppercase; decrypt.
        if(tcheck(argv[2]) && kcheck(argv[3])){
           cout << Decrypt(argv[2], argv[3]) << endl;    
        }
        
    }else {cout << "Unkown Argument or Flag. Please run without any arguments to see how to use." <<  endl;}

    return 0;

}
