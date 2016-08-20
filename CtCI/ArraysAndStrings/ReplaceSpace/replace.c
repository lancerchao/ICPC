#include <stdio.h>
#include <string.h>
#include <stdlib.h> 

void replace(char *string, int length);
int count_spaces(const char *string, int length);

int main(void)
{
	char *input = "Mr John Smith";
	int length = 13;
	char *string = malloc(18);
	memset(string, 65, 18);
	strncpy(string,input, strlen(input)+1);
	replace(string, length);
	printf("%s\n", string);
	input = "HelloWorld";
	length = 10;
	string = malloc(11);
	memset(string, 65, 11);
	strncpy(string, input, length+1);
	replace(string, length);
	printf("%s\n", string);
	return 0;
}

void replace(char *string, int length)
{
	int num_spaces = count_spaces(string, length);
	int indexToIncrement = num_spaces * 2;
	string[length + indexToIncrement] = '\0';
	for(int i=length-1;i>=0;i--)
	{
		int indexToIncrement = num_spaces * 2;
		if (string[i] == ' ')
		{
			string[i+indexToIncrement] = '0';
			string[i+indexToIncrement - 1] = '2';
			string[i+indexToIncrement - 2] = '%';
			num_spaces--;
		}
		else
		{
			string[i+indexToIncrement] = string[i];
		}
	}
}

int count_spaces(const char *string, int length)
{
	int num_spaces = 0;
	for(int i=0;i<length;i++)
	{
		if (string[i] == ' ')
			num_spaces++;
	}
	return num_spaces;
}