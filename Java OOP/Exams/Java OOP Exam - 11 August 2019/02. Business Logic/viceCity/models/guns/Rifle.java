package viceCity.models.guns;

public class Rifle extends BaseGun {
    private static final int ZERO_BULLETS = 0;
    private static final int RIFLE_BULLETS = 5;
    private static final int DEFAULT_BULLETS = 50;
    private static final int DEFAULT_TOTAL_BULLETS = 500;

    public Rifle(String name) {
        super(name, DEFAULT_BULLETS, DEFAULT_TOTAL_BULLETS);
    }

    @Override
    public int fire() {
        if (this.getBulletsPerBarrel() == ZERO_BULLETS) {
            this.reload();

            if (this.getBulletsPerBarrel() == ZERO_BULLETS) {
                return ZERO_BULLETS;
            }
        }

        this.setBulletsPerBarrel(this.getBulletsPerBarrel() - RIFLE_BULLETS);
        return RIFLE_BULLETS;
    }

    private void reload() {
        if (this.getTotalBullets() > ZERO_BULLETS) {
            int restTotalBullets = this.getTotalBullets() - DEFAULT_BULLETS;

            this.setTotalBullets(restTotalBullets);
            this.setBulletsPerBarrel(DEFAULT_BULLETS);
        }
    }
}

