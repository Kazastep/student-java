package edu.course.lab02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {

//     @Test
//     boolean TestForMinusBanckAccount() {
//         try {
//             BankAccount account = new BankAccount (-100);
//             return true;
//         } catch (IllegalArgumentException e){
//             return false;
//         }
//     }
// }

    // Тест для инциализации BanckAccount для отрицательного значения
    @Test
    void throwsExceptionForNegativeBankAccount() {
        assertThrows(IllegalArgumentException.class, 
            () -> new BankAccount(-100)
        );
    }

    // Тест для негативного параметра deposit
    @Test
    void throwsExceptionForNegativeDeposit() {
        assertThrows(IllegalArgumentException.class, 
            () -> { BankAccount account = new BankAccount(100);
                    account.deposit(-1);
            }
        );
    }

    // Тест для отрицательного параметра withdraw
    @Test
    void throwsExceptionForNegativeWithdraw() {
        assertThrows(IllegalArgumentException.class, 
            () -> { BankAccount account = new BankAccount(100);
                    account.withdraw(-1);
            }
        );
    }

    // Тест для большего параметра withdraw чем deposit
    @Test
    void throwsExceptionForBiggerWithdraw() {
        assertThrows(IllegalArgumentException.class, 
            () -> { BankAccount account = new BankAccount(100);
                    account.withdraw(110);
            }
        );
    }

    // Тест на положиткльное списание
    @Test 
    void withdrawReducesBalance() {
        BankAccount account = new BankAccount(100);
        account.withdraw(30);
        assertEquals(70,account.getBalance());
    }

}