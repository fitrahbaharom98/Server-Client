#include <stdio.h>

#include <sys/types.h> 

#include <sys/socket.h>

#include <string.h>

#include <stdlib.h>

#include <netinet/in.h>

#include <unistd.h> 

int main( int argc, char *argv[] )

{
	// Variables 
	int sock ;
	struct sockaddr_in client;
	int mysock;
	char buff [1024];
	int rval;
	char client_message[256] ;

	// Create Socket
	sock = socket(AF_INET, SOCK_STREAM , 0);
	if(sock < 0) {
		perror("Failed to create socket");
		exit(1);
	}


	client.sin_family = AF_INET;
	client.sin_addr.s_addr = INADDR_ANY;
	client.sin_port =htons(22000);

	// Call Bind 
	if(bind(sock, (struct sockaddr *)&client, sizeof(client)))
	{
		perror("Bind Failed");
		exit(1);
	}

	// Listen
	listen(sock , 10);

	// Accept

	do{
		mysock = accept(sock , (struct sockaddr *) 0, 0);	
			 
	        Previous:
	 
		if(mysock == -1)
		{
			perror("accept failed");
		}
		else
		{

		memset(buff, 0, sizeof(buff));

		if((rval = recv(mysock, buff, sizeof(buff), 0)) < 0)
		{ perror("reading stream message failed");    }
		
		else if (rval == 0)
		{ printf("Ending connection");  }

		else 
  		{

        	 recv(mysock, buff, sizeof(buff), 1);
		 printf("From Server: %s", buff);
		 recv(mysock, buff, sizeof(buff), 0);
		 printf("%s",buff);
		 printf("\n");
		 
		//goto Previous; 
		
		scanf ("%[^\n]%*c", client_message);
			 
                send(mysock,client_message,strlen(client_message),0);
		}
		
		close(mysock);
		}
	}while(1);

	return 0;

}
