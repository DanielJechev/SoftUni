package viceCity.models.guns;

public class Pistol extends BaseGun {
    private static final int ZERO_BULLETS = 0;
    private static final int PISTOL_BULLETS = 1;
    private static final int DEFAULT_BULLETS = 10;
    private static final int DEFAULT_TOTAL_BULLETS = 100;


    public Pistol(String name) {
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

        this.setBulletsPerBarrel(this.getBulletsPerBarrel() - PISTOL_BULLETS);
        return PISTOL_BULLETS;
    }

    private void reload() {
        if (this.getTotalBullets() > ZERO_BULLETS) {
            int restTotalBullets = this.getTotalBullets() - DEFAULT_BULLETS;

            this.setTotalBullets(restTotalBullets);
            this.setBulletsPerBarrel(DEFAULT_BULLETS);
        }
    }
}
