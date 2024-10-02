import socket


def start_server():
    server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    server_socket.bind(('0.0.0.0', 12345))  # Listen on all interfaces on port 12345
    server_socket.listen(5)
    print("Server listening on port 12345")

    while True:
        client_socket, addr = server_socket.accept()
        print(f"Connection from {addr}")
        handle_client(client_socket)

def handle_client(client_socket):
    while True:
        try:
            data = client_socket.recv(1024)  # Adjust buffer size as needed
            if not data:
                break
            p_data = data.decode()
            print(p_data)
        except KeyboardInterrupt :
            exit()    
        except Exception as e:
            print(f"Error: {e}")
            break
    client_socket.close()

if __name__ == "__main__":
    start_server()
