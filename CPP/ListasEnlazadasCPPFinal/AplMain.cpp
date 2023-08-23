#include "GummyBrandDAO.cpp"
#include <iostream>

using namespace std;

    int main()
    {
        GummyBrandDAO lista;
        string brand;
        string presentation;
        double price;
        
        /* lista.create(GummyBrandDTO("Marca1", "Presentation1", 100));
        lista.create(GummyBrandDTO("Marca2", "Presentation2", 200));
        lista.create(GummyBrandDTO("Marca3", "Presentation3", 300));
        lista.create(GummyBrandDTO("Marca4", "Presentation4", 400));
        
        cout << lista.display() << endl;
        
        lista.remove(3);
        
        cout << lista.display() << endl;
        
        lista.update(2, GummyBrandDTO("Marca2Update", "Pres2Update", 1000));
        
        cout << lista.display() << endl; */
        
        while(true){
            
            cout << "1) Create \n2) Remove\n3) Update\n4) Display\n5) Exit Program" << endl;
            int op;
            cin >> op;
            
            switch (op){
                //Create
                case 1:
                    cout << "Brand Name: " << endl;
                    cin >> brand;
                    cout << "Presentation Name: " << endl;
                    cin >> presentation;
                    cout << "Price: " << endl;
                    cin >> price;
                    
                    lista.create(GummyBrandDTO(brand, presentation, price));
                    cout << "New Brand Created" << endl;
                    
                    break;
                
                //Remove
                case 2:
                    int removeIndex;
                    cout << "Whats the index of the brand you wish to remove?" << endl;
                    cin >> removeIndex;
                    
                    lista.remove(removeIndex);
                    cout << "Brand Removed" << endl;
                    
                    break;
                    
                //Update
                case 3:
                    int updateIndex;
                    cout << "Whats the index of the brand you wish to update?" << endl;
                    cin >> updateIndex;

                    cout << "Brand Name: " << endl;
                    cin >> brand;
                    cout << "Presentation Name: " << endl;
                    cin >> presentation;
                    cout << "Price: " << endl;
                    cin >> price;
                    
                    lista.update(updateIndex, GummyBrandDTO(brand, presentation, price));
                    cout << "Brand Updated" << endl;
                
                
                    break;
                
                //Display 
                case 4:
                
                    cout << lista.display() << endl;
                
                    break;
                    
                //Exit
                case 5:
                
                    return 0;
                    break;
                
                default:
                    break;
            }
            
            
        }
        
        return 0;
    }