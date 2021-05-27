set -euo pipefail
IFS=$'\n\t'

function cleanup {
    echo "🧹 Cleanup..."
    rm -f gradle.properties golo-dev-sign.asc
}

trap cleanup SIGINT SIGTERM ERR EXIT

echo "🚀 Preparing to deploy..."

echo "🔑 Decrypting files..."

gpg --quiet --batch --yes --decrypt --passphrase="${GPG_SECRET}" \
    --output smoothbear04-sign.asc .github/workflows/commands/gpg/smoothbear04-sign.asc.gpg

gpg --quiet --batch --yes --decrypt --passphrase="${GPG_SECRET}" \
    --output gradle.properties .github/workflows/commands/gpg/gradle.properties.gpg

gpg --fast-import --no-tty --batch --yes .github/workflows/commands/gpg/smoothbear04-sign.asc

echo "📦 Publishing..."

gradle publish

echo "✅ Done!"