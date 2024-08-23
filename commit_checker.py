import subprocess
import os
 
def get_latest_commit_id():
    # Define the path to the Git executable
    git_path = r"C:\Users\40039440\AppData\Local\Programs\Git\cmd\git.exe"  # Replace with the correct path to your git.exe
 
    try:
        # Use the specified git path in the command
result = subprocess.run([git_path, "rev-parse", "HEAD"], stdout=subprocess.PIPE, text=True, check=True)
        return result.stdout.strip()
    except subprocess.CalledProcessError as e:
        print(f"Error executing git command: {e}")
        return None
    except FileNotFoundError:
        print("Git executable not found. Please ensure Git is installed and the path is correct.")
        return None
 
def read_stored_commit_id(file_path):
    if not os.path.exists(file_path):
        return None
    with open(file_path, 'r') as file:
        return file.read().strip()
 
def write_commit_id(file_path, commit_id):
    with open(file_path, 'w') as file:
        file.write(commit_id)
 
def check_and_update_commit_id():
    commit_file_path = 'stored_commit_id.txt'  # Path to the file storing the commit ID
 
    # Get the latest commit ID from the repository
    latest_commit_id = get_latest_commit_id()
 
    if latest_commit_id is None:
        print("Failed to retrieve the latest commit ID.")
        return
 
    # Read the stored commit ID from file
    stored_commit_id = read_stored_commit_id(commit_file_path)
 
    # Compare commit IDs
    if latest_commit_id != stored_commit_id:
        print(f"New commit detected: {latest_commit_id}. Updating stored commit ID.")
        write_commit_id(commit_file_path, latest_commit_id)
    else:
        print("No new commit detected.")
 
if __name__ == "__main__":
    check_and_update_commit_id()
