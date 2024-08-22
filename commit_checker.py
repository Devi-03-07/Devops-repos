import subprocess
 
# File to store the last commit ID
COMMIT_FILE = 'last_commit_id.txt'
 
def get_current_commit_id():
    # Use git command to get the latest commit ID
result = subprocess.run(['git', 'rev-parse', 'HEAD'], stdout=subprocess.PIPE, check=True)
    return result.stdout.decode('utf-8').strip()
 
def read_last_commit_id():
    try:
        with open(COMMIT_FILE, 'r') as f:
            return f.read().strip()
    except FileNotFoundError:
        return None
 
def write_commit_id(commit_id):
    with open(COMMIT_FILE, 'w') as f:
        f.write(commit_id)
 
def check_and_update_commit_id():
    current_commit_id = get_current_commit_id()
    last_commit_id = read_last_commit_id()
 
    if current_commit_id != last_commit_id:
        print(f"New commit detected: {current_commit_id}")
        write_commit_id(current_commit_id)
        return True
    else:
        print(f"No new commit. Current commit: {current_commit_id}")
        return False
 
if __name__ == "__main__":
    check_and_update_commit_id()
