set -euo pipefail
IFS=$'\n\t'

function cleanup {
    echo "๐งน Cleanup..."
    rm -f gradle.properties smoothbear04-sign.asc.gpg
}

trap cleanup SIGINT SIGTERM ERR EXIT

echo "๐ Preparing to deploy..."

echo "๐ Decrypting files..."

gpg --quiet --batch --yes --decrypt --passphrase="${GPG_SECRET}" \
    --output smoothbear04-sign.asc .github/workflows/commands/gpg/smoothbear04-sign.asc.gpg

gpg --quiet --batch --yes --decrypt --passphrase="${GPG_SECRET}" \
    --output gradle.properties .github/workflows/commands/gpg/gradle.properties.gpg

gpg --fast-import --no-tty --batch --yes smoothbear04-sign.asc

echo "๐ฆ Publishing..."

gradle publish

echo "โ Done!"
