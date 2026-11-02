# Releasing Dwurdy Cats

Releases are tag-driven. Push a tag matching `v**` and
[release.yml](.github/workflows/release.yml) builds the NeoForge jar, publishes it to
CurseForge + Modrinth, and creates a GitHub release.

## Tag → channel mapping

| Tag example | Publish channel |
|---|---|
| `v3.0.10-alpha+mc1.21.1` | Alpha |
| `v3.0.10-beta+mc1.21.1` | Beta |
| `v3.0.10+mc1.21.1` (anything else) | Release |

Matching is case-insensitive and looks for `alpha`/`beta` anywhere in the tag name.
Tags matching `v*-dev*` are excluded from the workflow entirely.

The channel is passed to Gradle as `-PreleaseType=<alpha|beta|release>` and
`RELEASE_TYPE`, then mapped in `neoforge/build.gradle` / `fabric/build.gradle`
(`publishMods { type = ... }`).

## One-time setup (maintainer)

1. **Create the project listings.** Create a CurseForge project and a Modrinth
   project for Dwurdy Cats. Both need approval before first publish.
2. **Set the project IDs** as Gradle properties (the build no longer hardcodes the
   upstream copycats+ IDs, so it cannot publish to the wrong listing):
   - `CURSEFORGE_PROJECT_ID` and `MODRINTH_PROJECT_ID` (repo variables or `-P` flags)
   - The `requires`/`optional` dependency IDs stay — they refer to Create/JEI, not
     this mod.
3. **Add repository secrets** (Settings → Secrets and variables → Actions):
   - `CURSEFORGE_TOKEN` — CurseForge API token
   - `MODRINTH_TOKEN` — Modrinth PAT (needs `CREATE_VERSION` + `PROJECT_WRITE`)
   - The publish step is skipped silently unless **both** are present.

## Cutting a release

```bash
git tag v3.0.10-beta+mc1.21.1 multiloader
git push origin v3.0.10-beta+mc1.21.1
```

The workflow runs `./gradlew :neoforge:build` first; publishing only happens after a
successful build. To dry-run the publish config locally:

```bash
./gradlew :neoforge:publishMods -PdoDryRun=true -PreleaseType=beta
```

## Before publishing publicly

Upstream Copycats+ is **all rights reserved**; its terms allow modification but
require a substantial portion of the code to be modified before redistribution.
Confirm the fork's standing (or get upstream's blessing) before the first public
CurseForge/Modrinth upload.
