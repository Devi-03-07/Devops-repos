
import subprocess
import os
 
def get_latest_commit_id():
    # This command gets the latest commit ID
result = subprocess.run(["git", "rev-parse", "HEAD"], stdout=subprocess.PIPE, text=True)
    return result.stdout.strip()
 
def read_stored_commit_id(file_path):
    if not os.path.exists(file_path):
        return None
    with open(file_path, 'r') as file:
        return file.read().strip()
 
def write_commit_id(file_path, commit_id):
    with open(file_path, 'w') as file:
        file.write(commit_id)
 
def main():
    commit_file_path = 'stored_commit_id.txt'  # Path to the file storing the commit ID
 
    # Get the latest commit ID from the repository
    latest_commit_id = get_latest_commit_id()
 
    # Read the stored commit ID from file
    stored_commit_id = read_stored_commit_id(commit_file_path)
 
    # Compare commit IDs
    if latest_commit_id != stored_commit_id:
        print(f"New commit detected: {latest_commit_id}. Updating stored commit ID.")
        write_commit_id(commit_file_path, latest_commit_id)
    else:
        print("No new commit detected.")
 
if __name__ == "__main__":
    main()
