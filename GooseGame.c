/*  Uday Kalvakota G01130227
 *  CS 262, Lab Section 212
 *  Project 1
 **/

#include <stdio.h>
#include <math.h>
#include <stdlib.h>

void menu(char* input)
{
	/*Creates a menu the takes the the user input to generate a random seed and asks player to play*/
	char inBuf[100];
	int seed = 0;

	/*creates seed	*/
	printf("\n\nEnter a seed for the random number generator: ");
	fgets(inBuf, 100, stdin);
	sscanf(inBuf, "%d", &seed);
	srand(seed);
	
	/*prompts player if they want to play the game*/
	printf("\n\nWelcome to the game of goose, please select an option:\nPress 'P' or 'p' to play or\nPress 'Q' or 'q' to quit.\nEnter an input: ");
	fgets(inBuf, 100, stdin);
	sscanf(inBuf, "%c", &*input);

	printf("\n");
}

void printBoard(int pPos, int cPos)
{
	/*prints the current boards including the players*/
	int i = 0;
	printf("\n");
	/*prints all spaces*/
	for (i = 1; i < 25; i++)
	{
		/*if a player, then it prints the player or the current space number*/
		if ( i == pPos && i == cPos)
		{
			printf("[$%%] ");	
		}
		else if ( i == pPos)
		{
			printf("[$] ");	
		}
		else if (i == cPos)
		{
			printf("[%%] ");	
		}		
		else if (i == 7 || i == 11 || i == 15)
		{
			printf("[+%d] ", i);
		}
		else if (i == 6)
		{
			printf("[*%d] ", i);
		}
		else if (i == 13 || i == 20)
		{
			printf("[-%d] ", i);
		}
		else if (i == 23)
		{
			printf("[!%d] ", i);
		}
		else
		{
			printf("[%d] ", i);
		}
		
		if(i == 12)
		{
			printf("\n");
		}
	}
	printf("\n");
	printf("\n");

}

void PlayGame()
{
	/*loops through the game process until it is complete*/
	int turn = 0;
	int winner = 0;
	int pPos= 1;
	int cPos = 1;
	int pLastRoll =  0;
	int cLastRoll = 0;
	int rollone, rolltwo, rollthree,rollfour,sumOne,sumTwo = 0;

	/*players until a winner is decided*/
	do
	{
		/*Decides which player goes first*/
		printf("HUMAN PLAYER, Press <enter> to roll the dice");
		getchar();
		rollone = (rand() % 6 ) + 1;
		rolltwo = (rand() % 6 ) + 1;
		sumOne = rollone + rolltwo;
		printf("%d and %d for a %d\n\n", rollone, rolltwo, rollone + rolltwo);
		
		printf("COMPUTER PLAYER, Press <enter> to roll the dice");
		getchar();
		rollthree = (rand() % 6 ) + 1;
		rollfour = (rand() % 6 ) + 1;
		sumTwo = rollthree + rollfour;
		
		printf("%d and %d for a %d\n\n", rollthree, rollfour, rollthree + rollfour);
		
		/*if turn is a factor os 2 the player goes first, else the computer*/
		if(sumOne > sumTwo)
		{
			turn = 0;
			printf("HUMAN PLAYER goes first\n");
		}
		else if(sumOne < sumTwo)
		{
			turn++;
			printf("COMPUTER PLAYER goes first\n");
		}
		else
		{
			printf("TIE: TRY AGAIN\n");
		}
	} while(sumOne == sumTwo);
	
	printBoard(pPos, cPos);
	
	do
	{
		if(turn % 2 == 0)
		{
			/*rolls for the player*/
			printf("PLAYER TURN: Press <enter> to roll the dice");
			getchar();
			rollone = (rand() % 6 ) + 1;
			rolltwo = (rand() % 6 ) + 1;
			sumOne = rollone + rolltwo;
			printf("%d and %d for a %d", rollone, rolltwo, rollone + rolltwo);
			
			/*moves the player to the summed space*/
			pPos += sumOne;
				
			printf(", go to space %d", pPos);
			
			/*checks if the moved to spot have a condition*/
			do
			{
				/*resets the player*/
				if(pPos == 23)
                                {
                                        pPos = 1;
                                        printf(", go to space %d", pPos);
                                }
				/*not the exact 24 so moves player backwards*/
				else if(pPos >24)
				{
					pPos =  (pPos + sumOne) - 24;
					printf(", go to space %d", pPos);
					
				}
				/*doubles the movement*/
				else if(pPos == 7 || pPos == 11 || pPos == 15)
				{
					pPos += sumOne;
					printf(", go to space %d", pPos);
				}
				/*moves player to 12*/
				else if(pPos == 6)
				{
					pPos = 12;
					printf(", go to space %d", pPos);
				}
				/*moves player to previous position*/
				else if(pPos == 13 || pPos == 20)
				{
					pPos = pLastRoll;
					printf(", go to space %d", pPos);
				}
				
			} while(pPos == 7 ||  pPos == 11 || pPos == 15 || pPos == 6 || pPos == 13 || pPos == 20 || pPos == 23 || pPos>24);
			/*checks if the player won*/
			if(pPos == 24)
                        {
                                printf("\n\nGAME OVER! PLAYER WINS");
                                winner++;
                        }
			
			/*saves the position and sets it to the computers turn*/
			pLastRoll = pPos;
			printf("\n");
			printBoard(pPos,cPos);
			turn++;
		}
		else if(turn % 2 == 1)
		{
			/*roll for sum of computers movement*/
			printf("COMPUTER TURN: Press <enter> to roll the dice");
			getchar();
			rollthree = (rand() % 6 ) + 1;
			rollfour = (rand() % 6 ) + 1;
			sumTwo = rollthree + rollfour;
			printf("%d and %d for a %d", rollthree, rollfour, rollthree + rollfour);
			
			/*moves computer*/
			cPos += sumTwo;
				
			printf(", go to space %d", cPos);
			
			/*checks if the moved to spot has a condition to be met*/
			do
			{
				
				if(cPos >24)
				{
					cPos =  (cPos + sumTwo) - 24;
					printf(", go to space %d", cPos);
				}
				else if(cPos == 7 || cPos == 11 || cPos == 15)
				{
					cPos += sumTwo;
					printf(", go to space %d", cPos);
				}
				else if(cPos == 6)
				{
					cPos = 12;
					printf(", go to space %d", cPos);
				}
				else if(cPos == 13 || cPos == 20)
				{
					cPos = cLastRoll;
					printf(", go to space %d", cPos);
				}
				else if(cPos == 23)
				{
					cPos = 1;
					printf(", go to space %d", cPos);
				}
				
			} while(cPos == 7 ||  cPos == 11 || cPos == 15 || cPos == 6 || cPos == 13 || cPos == 20 || cPos == 23 || cPos > 24);
			
			if(cPos == 24)
                        {
                                printf("\n\nGAME OVER! COMPUTER WON");
                                winner++;
                        }
			cLastRoll = cPos;
			printf("\n");
			printBoard(pPos,cPos);
			turn++;
		}
		
		
	} while(winner == 0);
	
}

int main()
{
	int run = 0;
	char input = ' ';
	
	/*continues to play the game till the user quits*/
	do
	{
		/*takes the user input from the menu to play the game or not*/
		menu(&input);
		switch (input)
		{
			case 'P':
			case 'p':
				PlayGame();
				break;
			case 'Q':
			case 'q':
				run ++;
				break;
			default:
				printf("\nInvalid Input\n");
		}
		
	} while(run == 0 );
	
	
	
	return 1;
}
