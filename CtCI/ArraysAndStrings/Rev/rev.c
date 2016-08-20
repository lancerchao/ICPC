#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char *rev_dup(const char *string);
void *rev_no_dup(char *string);
int main(int argc, char *argv[])
{
	char string[] = "helloworld";
	rev_no_dup(string);
	printf("%s\n", string);
	return 0;
}

char *rev_dup(const char *string)
{
	char *ret = malloc(strlen(string)+1);
	char *begin = ret;
	int end_index = strlen(string)-1;
	for(int i=0;i<strlen(string);i++)
	{
		*begin = string[end_index - i];
		begin++;
	}
	*begin = '\0';
	return ret;
}

void *rev_no_dup(char *string)
{
	size_t size = strlen(string);
	char *begin = string;
	char *end = begin+(size-1);
	char temp = 0;

	/* Do the swap */
	while(end > begin)
	{
		temp = *begin;
		*begin++ = *end;
		*end-- = temp;		
	}

}